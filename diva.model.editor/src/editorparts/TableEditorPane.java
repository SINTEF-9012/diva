/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package editorparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import diva.Expression;
import diva.NamedElement;
import diva.editor.DiVABackgroundProvider;
import diva.editor.DiVATextProvider;
import diva.editor.DiVATypeLabelProvider;
import diva.visitors.Visitable;

public abstract class TableEditorPane extends ViewerPane {
	
	protected AdapterFactory adapterFactory;
	protected TreeViewer treeViewerWithColumns;
	
	public StructuredViewer getStructuredviewer() {
		return treeViewerWithColumns;
	}
	
	public TableEditorPane(AdapterFactory adapterFactory, IWorkbenchPage page, IWorkbenchPart part) {
		super(page, part);
		this.adapterFactory = adapterFactory;
	}
	
	/** Initializes the table tree viewer, creating columns and setting up editing.
	 *  {@link #treeViewerWithColumns} should be valid before calling.
	 */
	protected abstract void initializeTableTreeViewer();

	/**
	 * @return list of {@link ColumnDescriptor}s
	 * @generated
	 */
	protected abstract List<ColumnDescriptor> getColumnDescriptors();
	
	protected List<ColumnDescriptor> getAllColumnDescriptorsForEClass(EClass c) {
		ArrayList<ColumnDescriptor> list = new ArrayList<ColumnDescriptor>();
		for (EStructuralFeature property : c.getEStructuralFeatures()) {
			list.add(new ColumnDescriptor(property.getName(), null, property.getName()));
		}
		return list;
	}
	
	
	protected ArrayList<TreeColumn> columns = new ArrayList<TreeColumn>();
	/** Sets up a viewer to contain columns as described by the list returned
	 * from {@link #getColumnDescriptors()}
	 * @param viewer
	 * @see ColumnDescriptor
	 */
	protected void createColumns(TreeViewer viewer) {

		TreeViewerColumn viewerColumn;
		TreeColumn column;
		
		/* Column 0 is always the tree itself */
		viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
		column = viewerColumn.getColumn();
		columns.add(column);
		//column.setText("Type");
		//column.setToolTipText("Type of the context variable");
		column.setWidth(100);
		viewerColumn.setLabelProvider(
				new PropertyColumnLabelProvider(
						adapterFactory,
						null
				)
		);
		//viewerColumn.setLabelProvider(editor.labelProvider);
		
		/* Now for the rest of the columns */
		IPropertySourceProvider provider = new AdapterFactoryContentProvider(adapterFactory);
		List<ColumnDescriptor> columnDescriptors = getColumnDescriptors();
		for (ColumnDescriptor descriptor : columnDescriptors) {
			viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
			column = viewerColumn.getColumn();
			columns.add(column);
			column.setText(descriptor.displayName);
			column.setToolTipText(descriptor.description);
			column.setAlignment(descriptor.alignment);
			column.setWidth(descriptor.width);
			viewerColumn.setLabelProvider(
					new PropertyColumnLabelProvider(
							adapterFactory,
							descriptor.featureName
					)
			);
			viewerColumn.setEditingSupport(
					new PropertyColumnEditingSupport(viewer, 
							provider,
							descriptor.propertyId)
			);
		}
	}
	
	
	
	public static class ColumnDescriptor {
		public Object propertyId;
		public String displayName;
		public String description;
		public String featureName;
		public int alignment;
		public int width;
		public ColumnDescriptor(Object propertyId, String displayName, String description, String featureName, int alignment, int width) {
			this.propertyId = propertyId;
			this.displayName = displayName;
			this.description = description;
			this.featureName = featureName;
			this.alignment = alignment;
			this.width = width;
		}
		public ColumnDescriptor(String name) {
			this(name, name, null, name.toLowerCase(), SWT.CENTER, 100);
		}
		public ColumnDescriptor(String name, String description) {
			this(name, name, description, name.toLowerCase(), SWT.CENTER, 100);
		}
		public ColumnDescriptor(String name, String description, String featureName) {
			this(featureName, name, description, featureName, SWT.CENTER, 100);
		}
	}
	
	public static class PropertyColumnEditingSupport extends EditingSupport {

		protected Object fPropertyId;
		protected IPropertySourceProvider fPropertySourceProvider;
		protected Map<Object, IPropertySource> fPropertySources;

		/**
		 * @param viewer The underlying control for this viewer must be a {@link Composite} or subclass thereof
		 * @param provider A provider that can provider {@link IPropertySource} for the domain objects. Typically, this should be an {@link AdapterFactoryContentProvider}.
		 * @param propertyId The propertyId associated with this column. All set and get methods will use this propertyId.
		 * 
		 * @see #setValue(Object, Object)
		 * @see #getValue(Object)
		 */
		public PropertyColumnEditingSupport(ColumnViewer viewer, 
				IPropertySourceProvider provider, 
				Object propertyId) {

			super(viewer);
			this.fPropertyId = propertyId;
			this.fPropertySourceProvider = provider;
			this.fPropertySources = new HashMap<Object, IPropertySource>();

		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
		 */
		protected boolean canEdit(Object element) {
			return getPropertyDescriptor(element) != null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
		 */
		protected org.eclipse.jface.viewers.CellEditor getCellEditor(Object element) {
			IPropertyDescriptor desc = getPropertyDescriptor(element);

			if (desc != null) {
				return desc.createPropertyEditor((Composite) getViewer().getControl());
			}

			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
		 */
		protected Object getValue(Object element) {

			IPropertySource propertySource = getPropertySource(element);
			if (propertySource != null) {
				Object value = propertySource.getPropertyValue(fPropertyId);
				if (value != null) {
					return getPropertySource(value).getEditableValue();
				}
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
		 */
		protected void setValue(Object element, Object value) {
			if (value == null) { // Need this check because somehow this gets called with value null
				return;
			}
			IPropertySource propertySource = getPropertySource(element);
			if (propertySource != null) {
				propertySource.setPropertyValue(fPropertyId, value);
				return;
			}
		}

		protected IPropertySource getPropertySource(Object element) {
			IPropertySource propertySource = fPropertySources.get(element);
			if (propertySource == null) {
				propertySource = fPropertySourceProvider.getPropertySource(element);
				fPropertySources.put(element, propertySource);
			}
			return propertySource;
		}

		protected IPropertyDescriptor getPropertyDescriptor(Object element) {
			IPropertySource propertySource = getPropertySource(element);
			if (propertySource != null) {
				IPropertyDescriptor descriptors[] = propertySource.getPropertyDescriptors();
				for (IPropertyDescriptor descriptor : descriptors) {
					if (descriptor.getId().equals(fPropertyId)) {
						return descriptor;
					}
				}
			}
			return null;
		}

	}
	

	public static class ExpressionColumnEditingSupport extends EditingSupport {

		protected Object fPropertyId;
		protected IPropertySourceProvider fPropertySourceProvider;
		protected Map<Object, IPropertySource> fPropertySources;

	/**
	 * @param viewer The underlying control for this viewer must be a {@link Composite} or subclass thereof
	 * @param provider A provider that can provider {@link IPropertySource} for the domain objects. Typically, this should be an {@link AdapterFactoryContentProvider}.
	 * @param propertyId The propertyId associated with this column. All set and get methods will use this propertyId.
	 * 
	 * @see #setValue(Object, Object)
	 * @see #getValue(Object)
	 */
		public ExpressionColumnEditingSupport(ColumnViewer viewer, 
			IPropertySourceProvider provider, 
			Object propertyId) {

		super(viewer);
		this.fPropertyId = propertyId;
		this.fPropertySourceProvider = provider;
		this.fPropertySources = new HashMap<Object, IPropertySource>();

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	protected boolean canEdit(Object element) {
		return getPropertyDescriptor(element) != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	protected org.eclipse.jface.viewers.CellEditor getCellEditor(Object element) {
		IPropertyDescriptor desc = getPropertyDescriptor(element);

		if (desc != null) {
			return desc.createPropertyEditor((Composite) getViewer().getControl());
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	protected Object getValue(Object element) {

		IPropertySource propertySource = getPropertySource(element);
		if (propertySource != null) {
			Object value = propertySource.getPropertyValue(fPropertyId);
			if (value != null) {
				return getPropertySource(value).getEditableValue();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	protected void setValue(Object element, Object value) {
		if (value == null) { // Need this check because somehow this gets called with value null
			return;
		}
		IPropertySource propertySource = getPropertySource(element);
		if (propertySource != null) {
			propertySource.setPropertyValue(fPropertyId, value);
			return;
		}
	}

	protected IPropertySource getPropertySource(Object element) {
		IPropertySource propertySource = fPropertySources.get(element);
		if (propertySource == null) {
			propertySource = fPropertySourceProvider.getPropertySource(element);
			fPropertySources.put(element, propertySource);
		}
		return propertySource;
	}

	protected IPropertyDescriptor getPropertyDescriptor(Object element) {
		IPropertySource propertySource = getPropertySource(element);
		if (propertySource != null) {
			IPropertyDescriptor descriptors[] = propertySource.getPropertyDescriptors();
			for (IPropertyDescriptor descriptor : descriptors) {
				if (descriptor.getId().equals(fPropertyId)) {
					return descriptor;
				}
			}
		}
		return null;
	}

}
	
	

	public class PropertyColumnLabelProvider extends ColumnLabelProvider {

		protected String fFeatureName;
		protected AdapterFactoryLabelProvider fLabelProvider;
		protected AdapterFactory fAdapterFactory;

		private org.eclipse.swt.graphics.Color fNoEditColor;
		
		private final static String NOEDIT_STRING = "-";

		/**
		 * @param factory
		 *            A factory that can provide label providers for the domain
		 *            objects
		 * @param featureName
		 *            Should be same as in
		 *            {@link EClass#getEStructuralFeature(String)}. Can be
		 *            <code>null</code>. If <code>null</code>, label is
		 *            provided for object itself.
		 */
		public PropertyColumnLabelProvider(AdapterFactory factory, String featureName) {
			super();
			this.fFeatureName = featureName;
			this.fLabelProvider = new AdapterFactoryLabelProvider(factory);
			this.fAdapterFactory = factory;
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
			}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (fFeatureName == null) {
				if (element instanceof Visitable) {
					return ((Visitable)element).accept(DiVATypeLabelProvider.getInstance(), null); 
				}
				else return fLabelProvider.getText(element);
			}

			EStructuralFeature feature = getFeature(element);
			if (feature != null) {
				Object value = ((EObject) element).eGet(feature);
				if (value != null) {
					if (value instanceof EList) {
						StringBuffer result = new StringBuffer();
						result.append("{");
						for (Object child : ((List<?>) value)) {
							if (result.length() != 1) {
								result.append(", ");
							}
							if (child instanceof NamedElement) {
								result.append(((NamedElement)child).getId());
							}
							else result.append(fLabelProvider.getText(child));
						}
						result.append("}");
						return result.toString();
					} else {
						if (value instanceof Expression) {
							return ((Expression)value).accept(DiVATextProvider.getInstance(), null);
						}
						return fLabelProvider.getText(value);
					}
				} else {
					return "";
				}
			}

			return NOEDIT_STRING;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
		 */
		@Override
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			if (fFeatureName == null) {
				Object img = fLabelProvider.getImage(element);
				if (img instanceof org.eclipse.swt.graphics.Image) {
					return (org.eclipse.swt.graphics.Image) img;
				}
			}
			return super.getImage(element);
		}

		protected EStructuralFeature getFeature(Object element) {
			if (element instanceof EObject) {
				return ((EObject) element).eClass().getEStructuralFeature(
						fFeatureName);
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
		 */
		@Override
		public void dispose() {
			this.fNoEditColor.dispose();
			super.dispose();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getBackground(java.lang.Object)
		 */
		@Override
		public org.eclipse.swt.graphics.Color getBackground(Object element) {
			if (fFeatureName != null && getFeature(element) == null) {
				return this.fNoEditColor;
			}
			else if (element instanceof Visitable) {
				return ((Visitable)element).accept(DiVABackgroundProvider.getInstance(), null); 
			}
			return super.getBackground(element);
		}

	}

	@Override
	public Viewer createViewer(Composite parent) {
		return new TreeViewer(parent, SWT.FULL_SELECTION);
	}

}
