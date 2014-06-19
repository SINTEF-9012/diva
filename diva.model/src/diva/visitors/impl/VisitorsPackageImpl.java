/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.visitors.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import diva.DivaPackage;
import diva.impl.DivaPackageImpl;
import diva.visitors.TopDownVisitor;
import diva.visitors.Visitable;
import diva.visitors.Visitor;
import diva.visitors.VisitorsFactory;
import diva.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisitorsPackageImpl extends EPackageImpl implements VisitorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topDownVisitorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see diva.visitors.VisitorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisitorsPackageImpl() {
		super(eNS_URI, VisitorsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VisitorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisitorsPackage init() {
		if (isInited) return (VisitorsPackage)EPackage.Registry.INSTANCE.getEPackage(VisitorsPackage.eNS_URI);

		// Obtain or create and register package
		VisitorsPackageImpl theVisitorsPackage = (VisitorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisitorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisitorsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DivaPackageImpl theDivaPackage = (DivaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DivaPackage.eNS_URI) instanceof DivaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DivaPackage.eNS_URI) : DivaPackage.eINSTANCE);

		// Create package meta-data objects
		theVisitorsPackage.createPackageContents();
		theDivaPackage.createPackageContents();

		// Initialize created meta-data
		theVisitorsPackage.initializePackageContents();
		theDivaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisitorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisitorsPackage.eNS_URI, theVisitorsPackage);
		return theVisitorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitable() {
		return visitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitor() {
		return visitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopDownVisitor() {
		return topDownVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitorsFactory getVisitorsFactory() {
		return (VisitorsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		visitableEClass = createEClass(VISITABLE);

		visitorEClass = createEClass(VISITOR);

		topDownVisitorEClass = createEClass(TOP_DOWN_VISITOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DivaPackage theDivaPackage = (DivaPackage)EPackage.Registry.INSTANCE.getEPackage(DivaPackage.eNS_URI);

		// Create type parameters
		ETypeParameter visitorEClass_ContextType = addETypeParameter(visitorEClass, "ContextType");
		ETypeParameter visitorEClass_ResultType = addETypeParameter(visitorEClass, "ResultType");
		ETypeParameter topDownVisitorEClass_ContextType = addETypeParameter(topDownVisitorEClass, "ContextType");
		ETypeParameter topDownVisitorEClass_ResultType = addETypeParameter(topDownVisitorEClass, "ResultType");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getVisitor());
		EGenericType g2 = createEGenericType(topDownVisitorEClass_ContextType);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(topDownVisitorEClass_ResultType);
		g1.getETypeArguments().add(g2);
		topDownVisitorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(visitableEClass, Visitable.class, "Visitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(visitableEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "C");
		ETypeParameter t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(visitorEClass, Visitor.class, "Visitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitorEClass, null, "visitVariabilityModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariabilityModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitInvariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getInvariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitEnumVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumVariable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitBooleanVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBooleanVariable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitAndTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getAndTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitOrTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getOrTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitNotTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getNotTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitVariantTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariantTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitEnumTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitBooleanTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBooleanTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitEnumLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumLiteral(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getDimension(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitContextExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContextExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitVariantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariantExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPriorityRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPriorityRule(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getProperty(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPropertyLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyLiteral(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPropertyValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPropertyPriority", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyPriority(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitMultiplicityConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getMultiplicityConstraint(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getAnnotation(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitSimulationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getSimulationModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContext(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfiguration(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitConfigVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfigVariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitScenario", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getScenario(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitScore", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getScore(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPriority", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPriority(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitBoolVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBoolVariableValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitEnumVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumVariableValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitConfigurationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfigurationModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitSuitableConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getSuitableConfiguration(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitContextModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContextModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		initEClass(topDownVisitorEClass, TopDownVisitor.class, "TopDownVisitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(topDownVisitorEClass, null, "visitVariabilityModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariabilityModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitInvariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getInvariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitEnumVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumVariable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitBooleanVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBooleanVariable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitAndTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getAndTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitOrTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getOrTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitNotTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getNotTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitVariantTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariantTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitEnumTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitBooleanTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBooleanTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitEnumLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumLiteral(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getDimension(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitContextExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContextExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitVariantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getVariantExpression(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPriorityRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPriorityRule(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getProperty(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPropertyLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyLiteral(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPropertyValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPropertyPriority", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPropertyPriority(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitMultiplicityConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getMultiplicityConstraint(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getAnnotation(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitSimulationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getSimulationModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContext(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfiguration(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitConfigVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfigVariant(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitScenario", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getScenario(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitScore", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getScore(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPriority", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getPriority(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitBoolVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getBoolVariableValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitEnumVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getEnumVariableValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitConfigurationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getConfigurationModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitSuitableConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getSuitableConfiguration(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitContextModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDivaPackage.getContextModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		// Create annotations
		// kermeta
		createKermetaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>kermeta</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createKermetaAnnotations() {
		String source = "kermeta";		
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nif node.model != void then node.model.accept(self, context) end\nnode.context.each{ e | e.accept(self, context) }\nnode.~property.each{ e | e.accept(self, context) }\nnode.dimension.each{ e | e.accept(self, context) }\nnode.rule.each{ e | e.accept(self, context) }\nnode.constraint.each{ e | e.accept(self, context) }\nif node.simulation != void then node.simulation.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.expression != void then node.expression.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.literal.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "do\nnode.term.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "do\nnode.term.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.term != void then node.term.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "do\nif node.model != void then node.model.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nnode.propertyValue.each{ e | e.accept(self, context) }\nif node.dependency != void then node.dependency.accept(self, context) end\nif node.available != void then node.available.accept(self, context) end\nif node.required != void then node.required.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variant.each{ e | e.accept(self, context) }\nnode.constraints.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(13), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.term != void then node.term.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(14), 
		   source, 
		   new String[] {
			 "body", "do\nif node.term != void then node.term.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(15), 
		   source, 
		   new String[] {
			 "body", "do\nif node.term != void then node.term.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(16), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.context != void then node.context.accept(self, context) end\nnode.priority.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(17), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.literal.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(18), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(19), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(20), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(21), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.available != void then node.available.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(22), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(23), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.scenario.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(24), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variable.each{ e | e.accept(self, context) }\nnode.configuration.each{ e | e.accept(self, context) }\nif node.oracle != void then node.oracle.accept(self, context) end\nnode.priority.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(25), 
		   source, 
		   new String[] {
			 "body", "do\nnode.score.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variant.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(26), 
		   source, 
		   new String[] {
			 "body", "do\nnode.score.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(27), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.context.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(28), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(29), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(30), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(31), 
		   source, 
		   new String[] {
			 "body", "do\nnode.annotation.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(32), 
		   source, 
		   new String[] {
			 "body", "do\nnode.configurations.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(33), 
		   source, 
		   new String[] {
			 "body", "do\nnode.variant.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(34), 
		   source, 
		   new String[] {
			 "body", "do\nnode.variable.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });	
	}

} //VisitorsPackageImpl
