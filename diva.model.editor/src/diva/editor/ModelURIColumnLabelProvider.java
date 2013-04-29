package diva.editor;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import diva.AspectModel;
import diva.BaseModel;
import diva.DivaPackage;
import diva.Model;
import diva.VariabilityModel;
import diva.Variant;
import diva.impl.DivaFactoryImpl;

public class ModelURIColumnLabelProvider extends ColumnLabelProvider implements Adapter {

	protected EReference property;

	private org.eclipse.swt.graphics.Color redColor;
	private org.eclipse.swt.graphics.Color greenColor;
	private org.eclipse.swt.graphics.Color fNoEditColor;
	
	private TreeViewer viewer;
	protected DiVATableEditor editor;

	private final static String NOEDIT_STRING = "-";

	public ModelURIColumnLabelProvider(EReference property, TreeViewer viewer, DiVATableEditor editor) {
		super();
		this.property = property;
		this.viewer = viewer;
		this.editor = editor;
		this.redColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 200, 200);
		this.greenColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 200, 255, 200);
		this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);	
	}
	
	Notifier eNotifier;

	
	public Notifier getTarget() {
		return eNotifier;
	}

	
	public boolean isAdapterForType(Object type) {
		return false;
	}

	
	public void notifyChanged(Notification notification) {
		if (viewer.isBusy()) return;
		if (notification.isTouch()) return;
		
		/* Just update the table if the property changes */
		if (notification.getNotifier() instanceof Model) {
			Model model = (Model)notification.getNotifier();
			if (notification.getFeature() == DivaPackage.eINSTANCE.getModel_Uri()) {
				viewer.update(model.eContainer(), null);
			}
		}
	}
	
	
	public void setTarget(Notifier newTarget) {
		eNotifier = newTarget;
	}
	
	
	public Color getToolTipBackgroundColor(Object element) {
		Model m = getModel(element);
		if (m != null) {
			if (fixObject(element)) {
				return greenColor;
			}
			else {
				return redColor;
			}
		}
		return super.getToolTipBackgroundColor(element);
	}
	
	
	public String getToolTipText(Object element) {
		Model m = getModel(element);
		if (m != null) {
			if (fixObject(element)) {
				return null;
			}
			else {
				return "The model could not be loaded, please check the URI and the content of the model.";
			}
		}
		return super.getToolTipText(element);
	}

	
	protected VariabilityModel getContainingModel(EObject target) {
		EObject current = target;
		VariabilityModel result = null;
		while (result == null && current != null)  {
			if (current instanceof VariabilityModel) result = (VariabilityModel)current;
			current = current.eContainer();
		}
		return result;
	}

	// return true if no errors and false otherwise. 
	// return false if there is no expression
	protected boolean fixObject(Object element) {
		Model m = getModel(element);
		
		if (m == null) {
			// create a Model
			if (element instanceof EObject) {
				EObject target = (EObject) element;
				if (((EClass)property.eContainer()).isInstance(target)) {
					Model nmod = null;
					if (target instanceof VariabilityModel)
						nmod = DivaFactoryImpl.init().createBaseModel();
					else if (target instanceof Variant)
						nmod = DivaFactoryImpl.init().createAspectModel();
					nmod.setUri("");
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), target, property, nmod);
					editor.getEditingDomain().getCommandStack().execute(cmd);
					m = nmod;
				}
			}
		}
		
		if (m != null) {
			EObject target = (EObject) element;
			
			if (!m.eAdapters().contains(this)) m.eAdapters().add(this);
			
			try {
				if (m.getUri() != null && !m.getUri().trim().equals("")) {
					// Check if the model exists
					ResourceSet rs = new ResourceSetImpl();
					URI xmiuri = URI.createURI(m.getUri(), true);
					Resource artres = rs.getResource(xmiuri, true);
					
					// And load it to check the content. This might be a bit too costly, we'll see.
					
						artres.load(null);
					
					EcoreUtil.resolveAll(artres);
					if (artres.getContents().size()>0) {
						if (m instanceof AspectModel) return artres.getContents().get(0).eClass().getName().equals("Aspect");
						else if (m instanceof BaseModel) return artres.getContents().get(0).eClass().getName().equals("System");
					}
				}
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	
	public String getText(Object element) {
		String result = NOEDIT_STRING;
		fixObject(element);
		Model m = getModel(element);
		if (m != null) {
			result = m.getUri();
		}
		return result;
	}

	
	public org.eclipse.swt.graphics.Image getImage(Object element) {
		return super.getImage(element);
	}

	
	public void dispose() {
		this.greenColor.dispose();
		this.redColor.dispose();
		this.fNoEditColor.dispose();
		super.dispose();
	}

	
	public org.eclipse.swt.graphics.Color getBackground(Object element) {
		Model m = getModel(element);
		if (m != null) {
			if (fixObject(element)) {
				return greenColor;
			}
			else {
				return redColor;
			}
		}
		return fNoEditColor;
	
	}
	
	protected Model getModel(Object element) {
		Model result = null;
		if (element instanceof EObject) {
			EObject target = (EObject) element;
			if (((EClass)property.eContainer()).isInstance(target)) {
				result = (Model) target.eGet(property);
			}
		}
		return result;
	}
}