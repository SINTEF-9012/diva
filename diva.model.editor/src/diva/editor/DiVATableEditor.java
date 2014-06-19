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
package diva.editor;


import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import diva.DivaFactory;
import diva.Property;
import diva.PropertyLiteral;
import diva.presentation.DiVA_Merged_visitorEditorPlugin;
import diva.presentation.DivaEditor;

public class DiVATableEditor extends DivaEditor {

	public DiVATableEditor() {
		super();
	}

	DiVALabelProvider labelProvider;
	
	protected ComposedAdapterFactory getAdaptedFactory() {
		return adapterFactory;
	}
	
	protected Composite getViewerPaneContainer() {
		return getContainer();
	}
	
	
	public void createDefaultProperties(Property prop) {
		PropertyLiteral l;
		String[] QosValues = {"-", "Very Low", "Low", "Medium", "High", "Very High" };
		
		final CompoundCommand cmd = new CompoundCommand();
		
		for(int i=0; i<QosValues.length; i++) {
			l = DivaFactory.eINSTANCE.createPropertyLiteral();
			l.setName(QosValues[i]);
			l.setValue(i);
			AddCommand add = new AddCommand(getEditingDomain(), prop.getLiteral(), l);
			cmd.append(add);
			//getEditingDomain().getCommandStack().execute(add);
		}
		
		getContainer().getDisplay().asyncExec
		 (new Runnable() {
			  public void run() {
				  getEditingDomain().getCommandStack().execute(cmd);
				  //firePropertyChange(IEditorPart.PROP_DIRTY);
			  }
		  });

		//getEditingDomain().getCommandStack().execute(cmd);
	}
	
	
	@Override
	public void createPages() {
		
		labelProvider = new DiVALabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty() &&
		    !(getEditingDomain().getResourceSet().getResources().get(0)).getContents().isEmpty()) {
			// Create a page for the selection tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), DiVATableEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							Tree tree = new Tree(composite, SWT.MULTI);
							TreeViewer newTreeViewer = new TreeViewer(tree);
							return newTreeViewer;
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				selectionViewer = (TreeViewer)viewerPane.getViewer();
				selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

				selectionViewer.setLabelProvider(labelProvider);
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_SelectionPage_label"));
			}
			
			// This is the page for the context editor
			//
			{
				ContextEditorPane viewerPane = new ContextEditorPane(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Context Editor");
			}
			
			// This is the page for the variant editor
			//
			{
				VariabilityEditorPane viewerPane = new VariabilityEditorPane(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Variability Editor");
			}
			
			// This is the page for the QoS Property definition
			//
			{
				PropertyEditorPane viewerPane = new PropertyEditorPane(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Property Editor");
			}

			// This is the page for the Variant QoS Editor
			//
			{
				QoSPropertyEditorPane viewerPane = new QoSPropertyEditorPane(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Variant QoS Editor");
			}
			
			// This is the page for the Rule Editor
			//
			{
				PriorityRuleEditorPane viewerPane = new PriorityRuleEditorPane(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Rules Editor");
			}
			
			// This is the page for the Simulator Input
			//
			{
				SimulationInputEditor viewerPane = new SimulationInputEditor(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Simulation Input Editor");
			}
			
			// This is the page for the Simulation Output
			//
			{
				SimulationOutputViewer viewerPane = new SimulationOutputViewer(this, getSite().getPage(), DiVATableEditor.this);
				createContextMenuFor(viewerPane.getStructuredviewer());
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Simulation Output Viewer");
			}
			
			getSite().getShell().getDisplay().asyncExec
				(new Runnable() {
					 public void run() {
						 setActivePage(0);
					 }
				 });
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			 });

		getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				 public void run() {
					 updateProblemIndication();
				 }
			 });
	}
	
	public void handleContentOutlineSelection(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == selectionViewer) {
					ArrayList<Object> selectionList = new ArrayList<Object>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					selectionViewer.setSelection(new StructuredSelection(selectionList));
				}
			}
		}
	}
	
	private static String getString(String key) {
		return DiVA_Merged_visitorEditorPlugin.INSTANCE.getString(key);
	}
	
	
}
