/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import diva.DivaFactory;
import diva.DivaPackage;
import diva.Variant;

/**
 * This is the item provider adapter for a {@link diva.Variant} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VariantItemProvider
	extends NamedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariantItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addWeaveLevelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Weave Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeaveLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Variant_weaveLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Variant_weaveLevel_feature", "_UI_Variant_type"),
				 DivaPackage.Literals.VARIANT__WEAVE_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DivaPackage.Literals.MODEL_CONTAINER__MODEL);
			childrenFeatures.add(DivaPackage.Literals.VARIANT__PROPERTY_VALUE);
			childrenFeatures.add(DivaPackage.Literals.VARIANT__DEPENDENCY);
			childrenFeatures.add(DivaPackage.Literals.VARIANT__AVAILABLE);
			childrenFeatures.add(DivaPackage.Literals.VARIANT__REQUIRED);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Variant.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Variant"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Variant)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Variant_type") :
			getString("_UI_Variant_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Variant.class)) {
			case DivaPackage.VARIANT__WEAVE_LEVEL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DivaPackage.VARIANT__MODEL:
			case DivaPackage.VARIANT__PROPERTY_VALUE:
			case DivaPackage.VARIANT__DEPENDENCY:
			case DivaPackage.VARIANT__AVAILABLE:
			case DivaPackage.VARIANT__REQUIRED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.MODEL_CONTAINER__MODEL,
				 DivaFactory.eINSTANCE.createBaseModel()));

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.MODEL_CONTAINER__MODEL,
				 DivaFactory.eINSTANCE.createAspectModel()));

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.VARIANT__PROPERTY_VALUE,
				 DivaFactory.eINSTANCE.createPropertyValue()));

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.VARIANT__DEPENDENCY,
				 DivaFactory.eINSTANCE.createVariantExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.VARIANT__AVAILABLE,
				 DivaFactory.eINSTANCE.createContextExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DivaPackage.Literals.VARIANT__REQUIRED,
				 DivaFactory.eINSTANCE.createContextExpression()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == DivaPackage.Literals.VARIANT__AVAILABLE ||
			childFeature == DivaPackage.Literals.VARIANT__REQUIRED;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
