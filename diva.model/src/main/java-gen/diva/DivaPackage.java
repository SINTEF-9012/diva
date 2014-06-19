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
package diva;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import diva.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see diva.DivaFactory
 * @model kind="package"
 * @generated
 */
public interface DivaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diva";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.diva.org/diva";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diva";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DivaPackage eINSTANCE = diva.impl.DivaPackageImpl.init();

	/**
	 * The meta object id for the '{@link diva.impl.DiVAModelElementImpl <em>Di VA Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.DiVAModelElementImpl
	 * @see diva.impl.DivaPackageImpl#getDiVAModelElement()
	 * @generated
	 */
	int DI_VA_MODEL_ELEMENT = 30;

	/**
	 * The meta object id for the '{@link diva.impl.VariabilityModelImpl <em>Variability Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariabilityModelImpl
	 * @see diva.impl.DivaPackageImpl#getVariabilityModel()
	 * @generated
	 */
	int VARIABILITY_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__DIMENSION = 2;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__RULE = 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Simulation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__SIMULATION = 5;

	/**
	 * The number of structural features of the '<em>Variability Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DI_VA_MODEL_ELEMENT__ANNOTATION = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Di VA Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DI_VA_MODEL_ELEMENT_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.NamedElementImpl
	 * @see diva.impl.DivaPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ConstraintImpl
	 * @see diva.impl.DivaPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 17;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = NAMED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.InvariantImpl <em>Invariant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.InvariantImpl
	 * @see diva.impl.DivaPackageImpl#getInvariant()
	 * @generated
	 */
	int INVARIANT = 1;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__ANNOTATION = CONSTRAINT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__ID = CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__EXPRESSION = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invariant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariableImpl
	 * @see diva.impl.DivaPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID = NAMED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.EnumVariableImpl <em>Enum Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.EnumVariableImpl
	 * @see diva.impl.DivaPackageImpl#getEnumVariable()
	 * @generated
	 */
	int ENUM_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE__ANNOTATION = VARIABLE__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE__ID = VARIABLE__ID;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE__LITERAL = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.BooleanVariableImpl <em>Boolean Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.BooleanVariableImpl
	 * @see diva.impl.DivaPackageImpl#getBooleanVariable()
	 * @generated
	 */
	int BOOLEAN_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__ANNOTATION = VARIABLE__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__ID = VARIABLE__ID;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE__QUERY = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.TermImpl
	 * @see diva.impl.DivaPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 5;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.NaryTermImpl <em>Nary Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.NaryTermImpl
	 * @see diva.impl.DivaPackageImpl#getNaryTerm()
	 * @generated
	 */
	int NARY_TERM = 9;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM__ANNOTATION = TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM__TERM = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.AndTermImpl <em>And Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.AndTermImpl
	 * @see diva.impl.DivaPackageImpl#getAndTerm()
	 * @generated
	 */
	int AND_TERM = 6;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_TERM__ANNOTATION = NARY_TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_TERM__TERM = NARY_TERM__TERM;

	/**
	 * The number of structural features of the '<em>And Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_TERM_FEATURE_COUNT = NARY_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.OrTermImpl <em>Or Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.OrTermImpl
	 * @see diva.impl.DivaPackageImpl#getOrTerm()
	 * @generated
	 */
	int OR_TERM = 7;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_TERM__ANNOTATION = NARY_TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_TERM__TERM = NARY_TERM__TERM;

	/**
	 * The number of structural features of the '<em>Or Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_TERM_FEATURE_COUNT = NARY_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.NotTermImpl <em>Not Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.NotTermImpl
	 * @see diva.impl.DivaPackageImpl#getNotTerm()
	 * @generated
	 */
	int NOT_TERM = 8;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_TERM__ANNOTATION = TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_TERM__TERM = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.VariantTermImpl <em>Variant Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariantTermImpl
	 * @see diva.impl.DivaPackageImpl#getVariantTerm()
	 * @generated
	 */
	int VARIANT_TERM = 10;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TERM__ANNOTATION = TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TERM__VARIANT = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variant Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.VariableTermImpl <em>Variable Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariableTermImpl
	 * @see diva.impl.DivaPackageImpl#getVariableTerm()
	 * @generated
	 */
	int VARIABLE_TERM = 11;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TERM__ANNOTATION = TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TERM__VARIABLE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.EnumTermImpl <em>Enum Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.EnumTermImpl
	 * @see diva.impl.DivaPackageImpl#getEnumTerm()
	 * @generated
	 */
	int ENUM_TERM = 12;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERM__ANNOTATION = VARIABLE_TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERM__VARIABLE = VARIABLE_TERM__VARIABLE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERM__VALUE = VARIABLE_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERM_FEATURE_COUNT = VARIABLE_TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.BooleanTermImpl <em>Boolean Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.BooleanTermImpl
	 * @see diva.impl.DivaPackageImpl#getBooleanTerm()
	 * @generated
	 */
	int BOOLEAN_TERM = 13;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERM__ANNOTATION = VARIABLE_TERM__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERM__VARIABLE = VARIABLE_TERM__VARIABLE;

	/**
	 * The number of structural features of the '<em>Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERM_FEATURE_COUNT = VARIABLE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.RuleImpl
	 * @see diva.impl.DivaPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 14;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ID = NAMED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.EnumLiteralImpl
	 * @see diva.impl.DivaPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__QUERY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariantImpl
	 * @see diva.impl.DivaPackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 18;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__PROPERTY_VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__DEPENDENCY = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Available</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__AVAILABLE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__REQUIRED = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link diva.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.DimensionImpl
	 * @see diva.impl.DivaPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 19;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__VARIANT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__PROPERTY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__UPPER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__LOWER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__CONSTRAINTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link diva.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ExpressionImpl
	 * @see diva.impl.DivaPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__TERM = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__TEXT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ContextExpressionImpl <em>Context Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ContextExpressionImpl
	 * @see diva.impl.DivaPackageImpl#getContextExpression()
	 * @generated
	 */
	int CONTEXT_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_EXPRESSION__ANNOTATION = EXPRESSION__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_EXPRESSION__TERM = EXPRESSION__TERM;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_EXPRESSION__TEXT = EXPRESSION__TEXT;

	/**
	 * The number of structural features of the '<em>Context Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.VariantExpressionImpl <em>Variant Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariantExpressionImpl
	 * @see diva.impl.DivaPackageImpl#getVariantExpression()
	 * @generated
	 */
	int VARIANT_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXPRESSION__ANNOTATION = EXPRESSION__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXPRESSION__TERM = EXPRESSION__TERM;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXPRESSION__TEXT = EXPRESSION__TEXT;

	/**
	 * The number of structural features of the '<em>Variant Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link diva.impl.PriorityRuleImpl <em>Priority Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PriorityRuleImpl
	 * @see diva.impl.DivaPackageImpl#getPriorityRule()
	 * @generated
	 */
	int PRIORITY_RULE = 23;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE__ANNOTATION = RULE__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE__NAME = RULE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE__ID = RULE__ID;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE__CONTEXT = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE__PRIORITY = RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Priority Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PropertyImpl
	 * @see diva.impl.DivaPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 24;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DIRECTION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LITERAL = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.PropertyLiteralImpl <em>Property Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PropertyLiteralImpl
	 * @see diva.impl.DivaPackageImpl#getPropertyLiteral()
	 * @generated
	 */
	int PROPERTY_LITERAL = 25;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LITERAL__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LITERAL__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LITERAL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.PropertyValueImpl <em>Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PropertyValueImpl
	 * @see diva.impl.DivaPackageImpl#getPropertyValue()
	 * @generated
	 */
	int PROPERTY_VALUE = 26;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__PROPERTY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__VALUE = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.PropertyPriorityImpl <em>Property Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PropertyPriorityImpl
	 * @see diva.impl.DivaPackageImpl#getPropertyPriority()
	 * @generated
	 */
	int PROPERTY_PRIORITY = 27;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PRIORITY__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PRIORITY__PROPERTY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PRIORITY__PRIORITY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PRIORITY_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.MultiplicityConstraintImpl <em>Multiplicity Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.MultiplicityConstraintImpl
	 * @see diva.impl.DivaPackageImpl#getMultiplicityConstraint()
	 * @generated
	 */
	int MULTIPLICITY_CONSTRAINT = 28;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__ANNOTATION = CONSTRAINT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__ID = CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Available</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__AVAILABLE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__UPPER = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT__LOWER = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multiplicity Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link diva.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.AnnotationImpl
	 * @see diva.impl.DivaPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 29;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__KEY = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__VALUE = VisitorsPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.SimulationModelImpl
	 * @see diva.impl.DivaPackageImpl#getSimulationModel()
	 * @generated
	 */
	int SIMULATION_MODEL = 31;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SCENARIO = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__MODEL = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ContextImpl
	 * @see diva.impl.DivaPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 32;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__VARIABLE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONFIGURATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Oracle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ORACLE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Verdict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__VERDICT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__PRIORITY = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link diva.impl.ScoredElementImpl <em>Scored Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ScoredElementImpl
	 * @see diva.impl.DivaPackageImpl#getScoredElement()
	 * @generated
	 */
	int SCORED_ELEMENT = 36;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORED_ELEMENT__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORED_ELEMENT__TOTAL_SCORE = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORED_ELEMENT__SCORE = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scored Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORED_ELEMENT_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ConfigurationImpl
	 * @see diva.impl.DivaPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 33;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ANNOTATION = SCORED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__TOTAL_SCORE = SCORED_ELEMENT__TOTAL_SCORE;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__SCORE = SCORED_ELEMENT__SCORE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VARIANT = SCORED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Verdict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VERDICT = SCORED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = SCORED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ConfigVariantImpl <em>Config Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ConfigVariantImpl
	 * @see diva.impl.DivaPackageImpl#getConfigVariant()
	 * @generated
	 */
	int CONFIG_VARIANT = 34;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VARIANT__ANNOTATION = SCORED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VARIANT__TOTAL_SCORE = SCORED_ELEMENT__TOTAL_SCORE;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VARIANT__SCORE = SCORED_ELEMENT__SCORE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VARIANT__VARIANT = SCORED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Config Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VARIANT_FEATURE_COUNT = SCORED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ScenarioImpl
	 * @see diva.impl.DivaPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 35;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ANNOTATION = NAMED_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.ScoreImpl <em>Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ScoreImpl
	 * @see diva.impl.DivaPackageImpl#getScore()
	 * @generated
	 */
	int SCORE = 37;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__SCORE = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__PROPERTY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.PriorityImpl <em>Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.PriorityImpl
	 * @see diva.impl.DivaPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 38;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__PROPERTY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__PRIORITY = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.VariableValueImpl <em>Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.VariableValueImpl
	 * @see diva.impl.DivaPackageImpl#getVariableValue()
	 * @generated
	 */
	int VARIABLE_VALUE = 39;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE__ANNOTATION = DI_VA_MODEL_ELEMENT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE__VARIABLE = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_FEATURE_COUNT = DI_VA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.BoolVariableValueImpl <em>Bool Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.BoolVariableValueImpl
	 * @see diva.impl.DivaPackageImpl#getBoolVariableValue()
	 * @generated
	 */
	int BOOL_VARIABLE_VALUE = 40;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VARIABLE_VALUE__ANNOTATION = VARIABLE_VALUE__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VARIABLE_VALUE__VARIABLE = VARIABLE_VALUE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Bool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VARIABLE_VALUE__BOOL = VARIABLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VARIABLE_VALUE_FEATURE_COUNT = VARIABLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.EnumVariableValueImpl <em>Enum Variable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.EnumVariableValueImpl
	 * @see diva.impl.DivaPackageImpl#getEnumVariableValue()
	 * @generated
	 */
	int ENUM_VARIABLE_VALUE = 41;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE_VALUE__ANNOTATION = VARIABLE_VALUE__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE_VALUE__VARIABLE = VARIABLE_VALUE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE_VALUE__LITERAL = VARIABLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Variable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VARIABLE_VALUE_FEATURE_COUNT = VARIABLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.ConfigurationModelImpl <em>Configuration Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ConfigurationModelImpl
	 * @see diva.impl.DivaPackageImpl#getConfigurationModel()
	 * @generated
	 */
	int CONFIGURATION_MODEL = 42;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL__CONFIGURATIONS = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configuration Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.SuitableConfigurationImpl <em>Suitable Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.SuitableConfigurationImpl
	 * @see diva.impl.DivaPackageImpl#getSuitableConfiguration()
	 * @generated
	 */
	int SUITABLE_CONFIGURATION = 43;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUITABLE_CONFIGURATION__SCORE = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUITABLE_CONFIGURATION__VARIANT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Suitable Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUITABLE_CONFIGURATION_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link diva.impl.ContextModelImpl <em>Context Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.ContextModelImpl
	 * @see diva.impl.DivaPackageImpl#getContextModel()
	 * @generated
	 */
	int CONTEXT_MODEL = 44;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MODEL__VARIABLE = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_MODEL_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link diva.impl.CEPableImpl <em>CE Pable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.CEPableImpl
	 * @see diva.impl.DivaPackageImpl#getCEPable()
	 * @generated
	 */
	int CE_PABLE = 45;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CE_PABLE__QUERY = 0;

	/**
	 * The number of structural features of the '<em>CE Pable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CE_PABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link diva.Verdict <em>Verdict</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.Verdict
	 * @see diva.impl.DivaPackageImpl#getVerdict()
	 * @generated
	 */
	int VERDICT = 46;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see diva.impl.DivaPackageImpl#getString()
	 * @generated
	 */
	int STRING = 47;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva.impl.DivaPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 48;


	/**
	 * Returns the meta object for class '{@link diva.VariabilityModel <em>Variability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variability Model</em>'.
	 * @see diva.VariabilityModel
	 * @generated
	 */
	EClass getVariabilityModel();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.VariabilityModel#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Context</em>'.
	 * @see diva.VariabilityModel#getContext()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Context();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.VariabilityModel#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see diva.VariabilityModel#getProperty()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.VariabilityModel#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimension</em>'.
	 * @see diva.VariabilityModel#getDimension()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Dimension();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.VariabilityModel#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see diva.VariabilityModel#getRule()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.VariabilityModel#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see diva.VariabilityModel#getConstraint()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Constraint();

	/**
	 * Returns the meta object for the containment reference '{@link diva.VariabilityModel#getSimulation <em>Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simulation</em>'.
	 * @see diva.VariabilityModel#getSimulation()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Simulation();

	/**
	 * Returns the meta object for class '{@link diva.Invariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant</em>'.
	 * @see diva.Invariant
	 * @generated
	 */
	EClass getInvariant();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Invariant#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see diva.Invariant#getExpression()
	 * @see #getInvariant()
	 * @generated
	 */
	EReference getInvariant_Expression();

	/**
	 * Returns the meta object for class '{@link diva.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see diva.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link diva.EnumVariable <em>Enum Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Variable</em>'.
	 * @see diva.EnumVariable
	 * @generated
	 */
	EClass getEnumVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.EnumVariable#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see diva.EnumVariable#getLiteral()
	 * @see #getEnumVariable()
	 * @generated
	 */
	EReference getEnumVariable_Literal();

	/**
	 * Returns the meta object for class '{@link diva.BooleanVariable <em>Boolean Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Variable</em>'.
	 * @see diva.BooleanVariable
	 * @generated
	 */
	EClass getBooleanVariable();

	/**
	 * Returns the meta object for class '{@link diva.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see diva.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link diva.AndTerm <em>And Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Term</em>'.
	 * @see diva.AndTerm
	 * @generated
	 */
	EClass getAndTerm();

	/**
	 * Returns the meta object for class '{@link diva.OrTerm <em>Or Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Term</em>'.
	 * @see diva.OrTerm
	 * @generated
	 */
	EClass getOrTerm();

	/**
	 * Returns the meta object for class '{@link diva.NotTerm <em>Not Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Term</em>'.
	 * @see diva.NotTerm
	 * @generated
	 */
	EClass getNotTerm();

	/**
	 * Returns the meta object for the containment reference '{@link diva.NotTerm#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see diva.NotTerm#getTerm()
	 * @see #getNotTerm()
	 * @generated
	 */
	EReference getNotTerm_Term();

	/**
	 * Returns the meta object for class '{@link diva.NaryTerm <em>Nary Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Term</em>'.
	 * @see diva.NaryTerm
	 * @generated
	 */
	EClass getNaryTerm();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.NaryTerm#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Term</em>'.
	 * @see diva.NaryTerm#getTerm()
	 * @see #getNaryTerm()
	 * @generated
	 */
	EReference getNaryTerm_Term();

	/**
	 * Returns the meta object for class '{@link diva.VariantTerm <em>Variant Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant Term</em>'.
	 * @see diva.VariantTerm
	 * @generated
	 */
	EClass getVariantTerm();

	/**
	 * Returns the meta object for the reference '{@link diva.VariantTerm#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variant</em>'.
	 * @see diva.VariantTerm#getVariant()
	 * @see #getVariantTerm()
	 * @generated
	 */
	EReference getVariantTerm_Variant();

	/**
	 * Returns the meta object for class '{@link diva.VariableTerm <em>Variable Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Term</em>'.
	 * @see diva.VariableTerm
	 * @generated
	 */
	EClass getVariableTerm();

	/**
	 * Returns the meta object for the reference '{@link diva.VariableTerm#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see diva.VariableTerm#getVariable()
	 * @see #getVariableTerm()
	 * @generated
	 */
	EReference getVariableTerm_Variable();

	/**
	 * Returns the meta object for class '{@link diva.EnumTerm <em>Enum Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Term</em>'.
	 * @see diva.EnumTerm
	 * @generated
	 */
	EClass getEnumTerm();

	/**
	 * Returns the meta object for the reference '{@link diva.EnumTerm#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see diva.EnumTerm#getValue()
	 * @see #getEnumTerm()
	 * @generated
	 */
	EReference getEnumTerm_Value();

	/**
	 * Returns the meta object for class '{@link diva.BooleanTerm <em>Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Term</em>'.
	 * @see diva.BooleanTerm
	 * @generated
	 */
	EClass getBooleanTerm();

	/**
	 * Returns the meta object for class '{@link diva.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see diva.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for class '{@link diva.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see diva.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for class '{@link diva.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see diva.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link diva.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see diva.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link diva.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see diva.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Id();

	/**
	 * Returns the meta object for class '{@link diva.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see diva.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link diva.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see diva.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the container reference '{@link diva.Variant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Type</em>'.
	 * @see diva.Variant#getType()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Variant#getPropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Value</em>'.
	 * @see diva.Variant#getPropertyValue()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_PropertyValue();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Variant#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependency</em>'.
	 * @see diva.Variant#getDependency()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Dependency();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Variant#getAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Available</em>'.
	 * @see diva.Variant#getAvailable()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Available();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Variant#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Required</em>'.
	 * @see diva.Variant#getRequired()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Required();

	/**
	 * Returns the meta object for class '{@link diva.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see diva.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Dimension#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see diva.Dimension#getVariant()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Variant();

	/**
	 * Returns the meta object for the reference list '{@link diva.Dimension#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property</em>'.
	 * @see diva.Dimension#getProperty()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Property();

	/**
	 * Returns the meta object for the attribute '{@link diva.Dimension#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see diva.Dimension#getUpper()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Upper();

	/**
	 * Returns the meta object for the attribute '{@link diva.Dimension#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see diva.Dimension#getLower()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Lower();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Dimension#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see diva.Dimension#getConstraints()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Constraints();

	/**
	 * Returns the meta object for class '{@link diva.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see diva.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Expression#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see diva.Expression#getTerm()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Term();

	/**
	 * Returns the meta object for the attribute '{@link diva.Expression#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see diva.Expression#getText()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Text();

	/**
	 * Returns the meta object for class '{@link diva.ContextExpression <em>Context Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Expression</em>'.
	 * @see diva.ContextExpression
	 * @generated
	 */
	EClass getContextExpression();

	/**
	 * Returns the meta object for class '{@link diva.VariantExpression <em>Variant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant Expression</em>'.
	 * @see diva.VariantExpression
	 * @generated
	 */
	EClass getVariantExpression();

	/**
	 * Returns the meta object for class '{@link diva.PriorityRule <em>Priority Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority Rule</em>'.
	 * @see diva.PriorityRule
	 * @generated
	 */
	EClass getPriorityRule();

	/**
	 * Returns the meta object for the containment reference '{@link diva.PriorityRule#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see diva.PriorityRule#getContext()
	 * @see #getPriorityRule()
	 * @generated
	 */
	EReference getPriorityRule_Context();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.PriorityRule#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Priority</em>'.
	 * @see diva.PriorityRule#getPriority()
	 * @see #getPriorityRule()
	 * @generated
	 */
	EReference getPriorityRule_Priority();

	/**
	 * Returns the meta object for class '{@link diva.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see diva.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link diva.Property#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see diva.Property#getDirection()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Direction();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Property#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see diva.Property#getLiteral()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Literal();

	/**
	 * Returns the meta object for class '{@link diva.PropertyLiteral <em>Property Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Literal</em>'.
	 * @see diva.PropertyLiteral
	 * @generated
	 */
	EClass getPropertyLiteral();

	/**
	 * Returns the meta object for the attribute '{@link diva.PropertyLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see diva.PropertyLiteral#getValue()
	 * @see #getPropertyLiteral()
	 * @generated
	 */
	EAttribute getPropertyLiteral_Value();

	/**
	 * Returns the meta object for class '{@link diva.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value</em>'.
	 * @see diva.PropertyValue
	 * @generated
	 */
	EClass getPropertyValue();

	/**
	 * Returns the meta object for the reference '{@link diva.PropertyValue#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see diva.PropertyValue#getProperty()
	 * @see #getPropertyValue()
	 * @generated
	 */
	EReference getPropertyValue_Property();

	/**
	 * Returns the meta object for the attribute '{@link diva.PropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see diva.PropertyValue#getValue()
	 * @see #getPropertyValue()
	 * @generated
	 */
	EAttribute getPropertyValue_Value();

	/**
	 * Returns the meta object for class '{@link diva.PropertyPriority <em>Property Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Priority</em>'.
	 * @see diva.PropertyPriority
	 * @generated
	 */
	EClass getPropertyPriority();

	/**
	 * Returns the meta object for the reference '{@link diva.PropertyPriority#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see diva.PropertyPriority#getProperty()
	 * @see #getPropertyPriority()
	 * @generated
	 */
	EReference getPropertyPriority_Property();

	/**
	 * Returns the meta object for the attribute '{@link diva.PropertyPriority#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see diva.PropertyPriority#getPriority()
	 * @see #getPropertyPriority()
	 * @generated
	 */
	EAttribute getPropertyPriority_Priority();

	/**
	 * Returns the meta object for class '{@link diva.MultiplicityConstraint <em>Multiplicity Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Constraint</em>'.
	 * @see diva.MultiplicityConstraint
	 * @generated
	 */
	EClass getMultiplicityConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link diva.MultiplicityConstraint#getAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Available</em>'.
	 * @see diva.MultiplicityConstraint#getAvailable()
	 * @see #getMultiplicityConstraint()
	 * @generated
	 */
	EReference getMultiplicityConstraint_Available();

	/**
	 * Returns the meta object for the attribute '{@link diva.MultiplicityConstraint#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see diva.MultiplicityConstraint#getUpper()
	 * @see #getMultiplicityConstraint()
	 * @generated
	 */
	EAttribute getMultiplicityConstraint_Upper();

	/**
	 * Returns the meta object for the attribute '{@link diva.MultiplicityConstraint#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see diva.MultiplicityConstraint#getLower()
	 * @see #getMultiplicityConstraint()
	 * @generated
	 */
	EAttribute getMultiplicityConstraint_Lower();

	/**
	 * Returns the meta object for class '{@link diva.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see diva.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link diva.Annotation#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see diva.Annotation#getKey()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Key();

	/**
	 * Returns the meta object for the attribute '{@link diva.Annotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see diva.Annotation#getValue()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Value();

	/**
	 * Returns the meta object for class '{@link diva.DiVAModelElement <em>Di VA Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Di VA Model Element</em>'.
	 * @see diva.DiVAModelElement
	 * @generated
	 */
	EClass getDiVAModelElement();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.DiVAModelElement#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation</em>'.
	 * @see diva.DiVAModelElement#getAnnotation()
	 * @see #getDiVAModelElement()
	 * @generated
	 */
	EReference getDiVAModelElement_Annotation();

	/**
	 * Returns the meta object for class '{@link diva.SimulationModel <em>Simulation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Model</em>'.
	 * @see diva.SimulationModel
	 * @generated
	 */
	EClass getSimulationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.SimulationModel#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenario</em>'.
	 * @see diva.SimulationModel#getScenario()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Scenario();

	/**
	 * Returns the meta object for the container reference '{@link diva.SimulationModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see diva.SimulationModel#getModel()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_Model();

	/**
	 * Returns the meta object for class '{@link diva.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see diva.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Context#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see diva.Context#getVariable()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Context#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration</em>'.
	 * @see diva.Context#getConfiguration()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link diva.Context#getOracle <em>Oracle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Oracle</em>'.
	 * @see diva.Context#getOracle()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Oracle();

	/**
	 * Returns the meta object for the attribute '{@link diva.Context#getVerdict <em>Verdict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verdict</em>'.
	 * @see diva.Context#getVerdict()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Verdict();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Context#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Priority</em>'.
	 * @see diva.Context#getPriority()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Priority();

	/**
	 * Returns the meta object for class '{@link diva.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see diva.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Configuration#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see diva.Configuration#getVariant()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Variant();

	/**
	 * Returns the meta object for the attribute '{@link diva.Configuration#getVerdict <em>Verdict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verdict</em>'.
	 * @see diva.Configuration#getVerdict()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Verdict();

	/**
	 * Returns the meta object for class '{@link diva.ConfigVariant <em>Config Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Variant</em>'.
	 * @see diva.ConfigVariant
	 * @generated
	 */
	EClass getConfigVariant();

	/**
	 * Returns the meta object for the reference '{@link diva.ConfigVariant#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variant</em>'.
	 * @see diva.ConfigVariant#getVariant()
	 * @see #getConfigVariant()
	 * @generated
	 */
	EReference getConfigVariant_Variant();

	/**
	 * Returns the meta object for class '{@link diva.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see diva.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.Scenario#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Context</em>'.
	 * @see diva.Scenario#getContext()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Context();

	/**
	 * Returns the meta object for class '{@link diva.ScoredElement <em>Scored Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scored Element</em>'.
	 * @see diva.ScoredElement
	 * @generated
	 */
	EClass getScoredElement();

	/**
	 * Returns the meta object for the attribute '{@link diva.ScoredElement#getTotalScore <em>Total Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Score</em>'.
	 * @see diva.ScoredElement#getTotalScore()
	 * @see #getScoredElement()
	 * @generated
	 */
	EAttribute getScoredElement_TotalScore();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.ScoredElement#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Score</em>'.
	 * @see diva.ScoredElement#getScore()
	 * @see #getScoredElement()
	 * @generated
	 */
	EReference getScoredElement_Score();

	/**
	 * Returns the meta object for class '{@link diva.Score <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score</em>'.
	 * @see diva.Score
	 * @generated
	 */
	EClass getScore();

	/**
	 * Returns the meta object for the attribute '{@link diva.Score#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see diva.Score#getScore()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_Score();

	/**
	 * Returns the meta object for the reference '{@link diva.Score#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see diva.Score#getProperty()
	 * @see #getScore()
	 * @generated
	 */
	EReference getScore_Property();

	/**
	 * Returns the meta object for class '{@link diva.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority</em>'.
	 * @see diva.Priority
	 * @generated
	 */
	EClass getPriority();

	/**
	 * Returns the meta object for the reference '{@link diva.Priority#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see diva.Priority#getProperty()
	 * @see #getPriority()
	 * @generated
	 */
	EReference getPriority_Property();

	/**
	 * Returns the meta object for the attribute '{@link diva.Priority#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see diva.Priority#getPriority()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_Priority();

	/**
	 * Returns the meta object for class '{@link diva.VariableValue <em>Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Value</em>'.
	 * @see diva.VariableValue
	 * @generated
	 */
	EClass getVariableValue();

	/**
	 * Returns the meta object for the reference '{@link diva.VariableValue#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see diva.VariableValue#getVariable()
	 * @see #getVariableValue()
	 * @generated
	 */
	EReference getVariableValue_Variable();

	/**
	 * Returns the meta object for class '{@link diva.BoolVariableValue <em>Bool Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Variable Value</em>'.
	 * @see diva.BoolVariableValue
	 * @generated
	 */
	EClass getBoolVariableValue();

	/**
	 * Returns the meta object for the attribute '{@link diva.BoolVariableValue#isBool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool</em>'.
	 * @see diva.BoolVariableValue#isBool()
	 * @see #getBoolVariableValue()
	 * @generated
	 */
	EAttribute getBoolVariableValue_Bool();

	/**
	 * Returns the meta object for class '{@link diva.EnumVariableValue <em>Enum Variable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Variable Value</em>'.
	 * @see diva.EnumVariableValue
	 * @generated
	 */
	EClass getEnumVariableValue();

	/**
	 * Returns the meta object for the reference '{@link diva.EnumVariableValue#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see diva.EnumVariableValue#getLiteral()
	 * @see #getEnumVariableValue()
	 * @generated
	 */
	EReference getEnumVariableValue_Literal();

	/**
	 * Returns the meta object for class '{@link diva.ConfigurationModel <em>Configuration Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Model</em>'.
	 * @see diva.ConfigurationModel
	 * @generated
	 */
	EClass getConfigurationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.ConfigurationModel#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see diva.ConfigurationModel#getConfigurations()
	 * @see #getConfigurationModel()
	 * @generated
	 */
	EReference getConfigurationModel_Configurations();

	/**
	 * Returns the meta object for class '{@link diva.SuitableConfiguration <em>Suitable Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suitable Configuration</em>'.
	 * @see diva.SuitableConfiguration
	 * @generated
	 */
	EClass getSuitableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link diva.SuitableConfiguration#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see diva.SuitableConfiguration#getScore()
	 * @see #getSuitableConfiguration()
	 * @generated
	 */
	EAttribute getSuitableConfiguration_Score();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.SuitableConfiguration#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see diva.SuitableConfiguration#getVariant()
	 * @see #getSuitableConfiguration()
	 * @generated
	 */
	EReference getSuitableConfiguration_Variant();

	/**
	 * Returns the meta object for class '{@link diva.ContextModel <em>Context Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Model</em>'.
	 * @see diva.ContextModel
	 * @generated
	 */
	EClass getContextModel();

	/**
	 * Returns the meta object for the containment reference list '{@link diva.ContextModel#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see diva.ContextModel#getVariable()
	 * @see #getContextModel()
	 * @generated
	 */
	EReference getContextModel_Variable();

	/**
	 * Returns the meta object for class '{@link diva.CEPable <em>CE Pable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CE Pable</em>'.
	 * @see diva.CEPable
	 * @generated
	 */
	EClass getCEPable();

	/**
	 * Returns the meta object for the attribute '{@link diva.CEPable#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see diva.CEPable#getQuery()
	 * @see #getCEPable()
	 * @generated
	 */
	EAttribute getCEPable_Query();

	/**
	 * Returns the meta object for enum '{@link diva.Verdict <em>Verdict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Verdict</em>'.
	 * @see diva.Verdict
	 * @generated
	 */
	EEnum getVerdict();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DivaFactory getDivaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link diva.impl.VariabilityModelImpl <em>Variability Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariabilityModelImpl
		 * @see diva.impl.DivaPackageImpl#getVariabilityModel()
		 * @generated
		 */
		EClass VARIABILITY_MODEL = eINSTANCE.getVariabilityModel();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__CONTEXT = eINSTANCE.getVariabilityModel_Context();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__PROPERTY = eINSTANCE.getVariabilityModel_Property();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__DIMENSION = eINSTANCE.getVariabilityModel_Dimension();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__RULE = eINSTANCE.getVariabilityModel_Rule();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__CONSTRAINT = eINSTANCE.getVariabilityModel_Constraint();

		/**
		 * The meta object literal for the '<em><b>Simulation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__SIMULATION = eINSTANCE.getVariabilityModel_Simulation();

		/**
		 * The meta object literal for the '{@link diva.impl.InvariantImpl <em>Invariant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.InvariantImpl
		 * @see diva.impl.DivaPackageImpl#getInvariant()
		 * @generated
		 */
		EClass INVARIANT = eINSTANCE.getInvariant();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVARIANT__EXPRESSION = eINSTANCE.getInvariant_Expression();

		/**
		 * The meta object literal for the '{@link diva.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariableImpl
		 * @see diva.impl.DivaPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link diva.impl.EnumVariableImpl <em>Enum Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.EnumVariableImpl
		 * @see diva.impl.DivaPackageImpl#getEnumVariable()
		 * @generated
		 */
		EClass ENUM_VARIABLE = eINSTANCE.getEnumVariable();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_VARIABLE__LITERAL = eINSTANCE.getEnumVariable_Literal();

		/**
		 * The meta object literal for the '{@link diva.impl.BooleanVariableImpl <em>Boolean Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.BooleanVariableImpl
		 * @see diva.impl.DivaPackageImpl#getBooleanVariable()
		 * @generated
		 */
		EClass BOOLEAN_VARIABLE = eINSTANCE.getBooleanVariable();

		/**
		 * The meta object literal for the '{@link diva.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.TermImpl
		 * @see diva.impl.DivaPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link diva.impl.AndTermImpl <em>And Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.AndTermImpl
		 * @see diva.impl.DivaPackageImpl#getAndTerm()
		 * @generated
		 */
		EClass AND_TERM = eINSTANCE.getAndTerm();

		/**
		 * The meta object literal for the '{@link diva.impl.OrTermImpl <em>Or Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.OrTermImpl
		 * @see diva.impl.DivaPackageImpl#getOrTerm()
		 * @generated
		 */
		EClass OR_TERM = eINSTANCE.getOrTerm();

		/**
		 * The meta object literal for the '{@link diva.impl.NotTermImpl <em>Not Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.NotTermImpl
		 * @see diva.impl.DivaPackageImpl#getNotTerm()
		 * @generated
		 */
		EClass NOT_TERM = eINSTANCE.getNotTerm();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_TERM__TERM = eINSTANCE.getNotTerm_Term();

		/**
		 * The meta object literal for the '{@link diva.impl.NaryTermImpl <em>Nary Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.NaryTermImpl
		 * @see diva.impl.DivaPackageImpl#getNaryTerm()
		 * @generated
		 */
		EClass NARY_TERM = eINSTANCE.getNaryTerm();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_TERM__TERM = eINSTANCE.getNaryTerm_Term();

		/**
		 * The meta object literal for the '{@link diva.impl.VariantTermImpl <em>Variant Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariantTermImpl
		 * @see diva.impl.DivaPackageImpl#getVariantTerm()
		 * @generated
		 */
		EClass VARIANT_TERM = eINSTANCE.getVariantTerm();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_TERM__VARIANT = eINSTANCE.getVariantTerm_Variant();

		/**
		 * The meta object literal for the '{@link diva.impl.VariableTermImpl <em>Variable Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariableTermImpl
		 * @see diva.impl.DivaPackageImpl#getVariableTerm()
		 * @generated
		 */
		EClass VARIABLE_TERM = eINSTANCE.getVariableTerm();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TERM__VARIABLE = eINSTANCE.getVariableTerm_Variable();

		/**
		 * The meta object literal for the '{@link diva.impl.EnumTermImpl <em>Enum Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.EnumTermImpl
		 * @see diva.impl.DivaPackageImpl#getEnumTerm()
		 * @generated
		 */
		EClass ENUM_TERM = eINSTANCE.getEnumTerm();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_TERM__VALUE = eINSTANCE.getEnumTerm_Value();

		/**
		 * The meta object literal for the '{@link diva.impl.BooleanTermImpl <em>Boolean Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.BooleanTermImpl
		 * @see diva.impl.DivaPackageImpl#getBooleanTerm()
		 * @generated
		 */
		EClass BOOLEAN_TERM = eINSTANCE.getBooleanTerm();

		/**
		 * The meta object literal for the '{@link diva.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.RuleImpl
		 * @see diva.impl.DivaPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '{@link diva.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.EnumLiteralImpl
		 * @see diva.impl.DivaPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '{@link diva.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.NamedElementImpl
		 * @see diva.impl.DivaPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '{@link diva.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ConstraintImpl
		 * @see diva.impl.DivaPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link diva.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariantImpl
		 * @see diva.impl.DivaPackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__TYPE = eINSTANCE.getVariant_Type();

		/**
		 * The meta object literal for the '<em><b>Property Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__PROPERTY_VALUE = eINSTANCE.getVariant_PropertyValue();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__DEPENDENCY = eINSTANCE.getVariant_Dependency();

		/**
		 * The meta object literal for the '<em><b>Available</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__AVAILABLE = eINSTANCE.getVariant_Available();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__REQUIRED = eINSTANCE.getVariant_Required();

		/**
		 * The meta object literal for the '{@link diva.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.DimensionImpl
		 * @see diva.impl.DivaPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__VARIANT = eINSTANCE.getDimension_Variant();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__PROPERTY = eINSTANCE.getDimension_Property();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__UPPER = eINSTANCE.getDimension_Upper();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__LOWER = eINSTANCE.getDimension_Lower();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__CONSTRAINTS = eINSTANCE.getDimension_Constraints();

		/**
		 * The meta object literal for the '{@link diva.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ExpressionImpl
		 * @see diva.impl.DivaPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__TERM = eINSTANCE.getExpression_Term();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__TEXT = eINSTANCE.getExpression_Text();

		/**
		 * The meta object literal for the '{@link diva.impl.ContextExpressionImpl <em>Context Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ContextExpressionImpl
		 * @see diva.impl.DivaPackageImpl#getContextExpression()
		 * @generated
		 */
		EClass CONTEXT_EXPRESSION = eINSTANCE.getContextExpression();

		/**
		 * The meta object literal for the '{@link diva.impl.VariantExpressionImpl <em>Variant Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariantExpressionImpl
		 * @see diva.impl.DivaPackageImpl#getVariantExpression()
		 * @generated
		 */
		EClass VARIANT_EXPRESSION = eINSTANCE.getVariantExpression();

		/**
		 * The meta object literal for the '{@link diva.impl.PriorityRuleImpl <em>Priority Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PriorityRuleImpl
		 * @see diva.impl.DivaPackageImpl#getPriorityRule()
		 * @generated
		 */
		EClass PRIORITY_RULE = eINSTANCE.getPriorityRule();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORITY_RULE__CONTEXT = eINSTANCE.getPriorityRule_Context();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORITY_RULE__PRIORITY = eINSTANCE.getPriorityRule_Priority();

		/**
		 * The meta object literal for the '{@link diva.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PropertyImpl
		 * @see diva.impl.DivaPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DIRECTION = eINSTANCE.getProperty_Direction();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__LITERAL = eINSTANCE.getProperty_Literal();

		/**
		 * The meta object literal for the '{@link diva.impl.PropertyLiteralImpl <em>Property Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PropertyLiteralImpl
		 * @see diva.impl.DivaPackageImpl#getPropertyLiteral()
		 * @generated
		 */
		EClass PROPERTY_LITERAL = eINSTANCE.getPropertyLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_LITERAL__VALUE = eINSTANCE.getPropertyLiteral_Value();

		/**
		 * The meta object literal for the '{@link diva.impl.PropertyValueImpl <em>Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PropertyValueImpl
		 * @see diva.impl.DivaPackageImpl#getPropertyValue()
		 * @generated
		 */
		EClass PROPERTY_VALUE = eINSTANCE.getPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE__PROPERTY = eINSTANCE.getPropertyValue_Property();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_VALUE__VALUE = eINSTANCE.getPropertyValue_Value();

		/**
		 * The meta object literal for the '{@link diva.impl.PropertyPriorityImpl <em>Property Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PropertyPriorityImpl
		 * @see diva.impl.DivaPackageImpl#getPropertyPriority()
		 * @generated
		 */
		EClass PROPERTY_PRIORITY = eINSTANCE.getPropertyPriority();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PRIORITY__PROPERTY = eINSTANCE.getPropertyPriority_Property();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_PRIORITY__PRIORITY = eINSTANCE.getPropertyPriority_Priority();

		/**
		 * The meta object literal for the '{@link diva.impl.MultiplicityConstraintImpl <em>Multiplicity Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.MultiplicityConstraintImpl
		 * @see diva.impl.DivaPackageImpl#getMultiplicityConstraint()
		 * @generated
		 */
		EClass MULTIPLICITY_CONSTRAINT = eINSTANCE.getMultiplicityConstraint();

		/**
		 * The meta object literal for the '<em><b>Available</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_CONSTRAINT__AVAILABLE = eINSTANCE.getMultiplicityConstraint_Available();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_CONSTRAINT__UPPER = eINSTANCE.getMultiplicityConstraint_Upper();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_CONSTRAINT__LOWER = eINSTANCE.getMultiplicityConstraint_Lower();

		/**
		 * The meta object literal for the '{@link diva.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.AnnotationImpl
		 * @see diva.impl.DivaPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__KEY = eINSTANCE.getAnnotation_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__VALUE = eINSTANCE.getAnnotation_Value();

		/**
		 * The meta object literal for the '{@link diva.impl.DiVAModelElementImpl <em>Di VA Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.DiVAModelElementImpl
		 * @see diva.impl.DivaPackageImpl#getDiVAModelElement()
		 * @generated
		 */
		EClass DI_VA_MODEL_ELEMENT = eINSTANCE.getDiVAModelElement();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DI_VA_MODEL_ELEMENT__ANNOTATION = eINSTANCE.getDiVAModelElement_Annotation();

		/**
		 * The meta object literal for the '{@link diva.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.SimulationModelImpl
		 * @see diva.impl.DivaPackageImpl#getSimulationModel()
		 * @generated
		 */
		EClass SIMULATION_MODEL = eINSTANCE.getSimulationModel();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__SCENARIO = eINSTANCE.getSimulationModel_Scenario();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__MODEL = eINSTANCE.getSimulationModel_Model();

		/**
		 * The meta object literal for the '{@link diva.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ContextImpl
		 * @see diva.impl.DivaPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__VARIABLE = eINSTANCE.getContext_Variable();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__CONFIGURATION = eINSTANCE.getContext_Configuration();

		/**
		 * The meta object literal for the '<em><b>Oracle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__ORACLE = eINSTANCE.getContext_Oracle();

		/**
		 * The meta object literal for the '<em><b>Verdict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__VERDICT = eINSTANCE.getContext_Verdict();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__PRIORITY = eINSTANCE.getContext_Priority();

		/**
		 * The meta object literal for the '{@link diva.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ConfigurationImpl
		 * @see diva.impl.DivaPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__VARIANT = eINSTANCE.getConfiguration_Variant();

		/**
		 * The meta object literal for the '<em><b>Verdict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__VERDICT = eINSTANCE.getConfiguration_Verdict();

		/**
		 * The meta object literal for the '{@link diva.impl.ConfigVariantImpl <em>Config Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ConfigVariantImpl
		 * @see diva.impl.DivaPackageImpl#getConfigVariant()
		 * @generated
		 */
		EClass CONFIG_VARIANT = eINSTANCE.getConfigVariant();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_VARIANT__VARIANT = eINSTANCE.getConfigVariant_Variant();

		/**
		 * The meta object literal for the '{@link diva.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ScenarioImpl
		 * @see diva.impl.DivaPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__CONTEXT = eINSTANCE.getScenario_Context();

		/**
		 * The meta object literal for the '{@link diva.impl.ScoredElementImpl <em>Scored Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ScoredElementImpl
		 * @see diva.impl.DivaPackageImpl#getScoredElement()
		 * @generated
		 */
		EClass SCORED_ELEMENT = eINSTANCE.getScoredElement();

		/**
		 * The meta object literal for the '<em><b>Total Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORED_ELEMENT__TOTAL_SCORE = eINSTANCE.getScoredElement_TotalScore();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORED_ELEMENT__SCORE = eINSTANCE.getScoredElement_Score();

		/**
		 * The meta object literal for the '{@link diva.impl.ScoreImpl <em>Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ScoreImpl
		 * @see diva.impl.DivaPackageImpl#getScore()
		 * @generated
		 */
		EClass SCORE = eINSTANCE.getScore();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__SCORE = eINSTANCE.getScore_Score();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORE__PROPERTY = eINSTANCE.getScore_Property();

		/**
		 * The meta object literal for the '{@link diva.impl.PriorityImpl <em>Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.PriorityImpl
		 * @see diva.impl.DivaPackageImpl#getPriority()
		 * @generated
		 */
		EClass PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIORITY__PROPERTY = eINSTANCE.getPriority_Property();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY__PRIORITY = eINSTANCE.getPriority_Priority();

		/**
		 * The meta object literal for the '{@link diva.impl.VariableValueImpl <em>Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.VariableValueImpl
		 * @see diva.impl.DivaPackageImpl#getVariableValue()
		 * @generated
		 */
		EClass VARIABLE_VALUE = eINSTANCE.getVariableValue();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_VALUE__VARIABLE = eINSTANCE.getVariableValue_Variable();

		/**
		 * The meta object literal for the '{@link diva.impl.BoolVariableValueImpl <em>Bool Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.BoolVariableValueImpl
		 * @see diva.impl.DivaPackageImpl#getBoolVariableValue()
		 * @generated
		 */
		EClass BOOL_VARIABLE_VALUE = eINSTANCE.getBoolVariableValue();

		/**
		 * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_VARIABLE_VALUE__BOOL = eINSTANCE.getBoolVariableValue_Bool();

		/**
		 * The meta object literal for the '{@link diva.impl.EnumVariableValueImpl <em>Enum Variable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.EnumVariableValueImpl
		 * @see diva.impl.DivaPackageImpl#getEnumVariableValue()
		 * @generated
		 */
		EClass ENUM_VARIABLE_VALUE = eINSTANCE.getEnumVariableValue();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_VARIABLE_VALUE__LITERAL = eINSTANCE.getEnumVariableValue_Literal();

		/**
		 * The meta object literal for the '{@link diva.impl.ConfigurationModelImpl <em>Configuration Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ConfigurationModelImpl
		 * @see diva.impl.DivaPackageImpl#getConfigurationModel()
		 * @generated
		 */
		EClass CONFIGURATION_MODEL = eINSTANCE.getConfigurationModel();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_MODEL__CONFIGURATIONS = eINSTANCE.getConfigurationModel_Configurations();

		/**
		 * The meta object literal for the '{@link diva.impl.SuitableConfigurationImpl <em>Suitable Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.SuitableConfigurationImpl
		 * @see diva.impl.DivaPackageImpl#getSuitableConfiguration()
		 * @generated
		 */
		EClass SUITABLE_CONFIGURATION = eINSTANCE.getSuitableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUITABLE_CONFIGURATION__SCORE = eINSTANCE.getSuitableConfiguration_Score();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUITABLE_CONFIGURATION__VARIANT = eINSTANCE.getSuitableConfiguration_Variant();

		/**
		 * The meta object literal for the '{@link diva.impl.ContextModelImpl <em>Context Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.ContextModelImpl
		 * @see diva.impl.DivaPackageImpl#getContextModel()
		 * @generated
		 */
		EClass CONTEXT_MODEL = eINSTANCE.getContextModel();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_MODEL__VARIABLE = eINSTANCE.getContextModel_Variable();

		/**
		 * The meta object literal for the '{@link diva.impl.CEPableImpl <em>CE Pable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.CEPableImpl
		 * @see diva.impl.DivaPackageImpl#getCEPable()
		 * @generated
		 */
		EClass CE_PABLE = eINSTANCE.getCEPable();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CE_PABLE__QUERY = eINSTANCE.getCEPable_Query();

		/**
		 * The meta object literal for the '{@link diva.Verdict <em>Verdict</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.Verdict
		 * @see diva.impl.DivaPackageImpl#getVerdict()
		 * @generated
		 */
		EEnum VERDICT = eINSTANCE.getVerdict();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see diva.impl.DivaPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva.impl.DivaPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

	}

} //DivaPackage
