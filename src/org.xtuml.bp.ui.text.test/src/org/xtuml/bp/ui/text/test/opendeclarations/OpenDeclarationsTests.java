//=====================================================================
//
// NOTE: This file was generated, but is maintained by hand.
// Generated by: UnitTestGenerator.pl
// Version:      1.15
// Matrix:       9761_9762_find_declarations_matrix.txt
//
//=====================================================================

package org.xtuml.bp.ui.text.test.opendeclarations;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.xtuml.bp.core.ActionHome_c;
import org.xtuml.bp.core.Action_c;
import org.xtuml.bp.core.Association_c;
import org.xtuml.bp.core.Attribute_c;
import org.xtuml.bp.core.Body_c;
import org.xtuml.bp.core.BridgeBody_c;
import org.xtuml.bp.core.BridgeParameter_c;
import org.xtuml.bp.core.Bridge_c;
import org.xtuml.bp.core.DerivedAttributeBody_c;
import org.xtuml.bp.core.DerivedBaseAttribute_c;
import org.xtuml.bp.core.EventSupplementalData_c;
import org.xtuml.bp.core.ExecutableProperty_c;
import org.xtuml.bp.core.ExternalEntity_c;
import org.xtuml.bp.core.FunctionBody_c;
import org.xtuml.bp.core.FunctionParameter_c;
import org.xtuml.bp.core.Function_c;
import org.xtuml.bp.core.InterfaceOperation_c;
import org.xtuml.bp.core.InterfaceSignal_c;
import org.xtuml.bp.core.ModelClass_c;
import org.xtuml.bp.core.MooreActionHome_c;
import org.xtuml.bp.core.NewStateTransition_c;
import org.xtuml.bp.core.Ooaofooa;
import org.xtuml.bp.core.OperationBody_c;
import org.xtuml.bp.core.OperationParameter_c;
import org.xtuml.bp.core.Operation_c;
import org.xtuml.bp.core.Port_c;
import org.xtuml.bp.core.PropertyParameter_c;
import org.xtuml.bp.core.ProvidedExecutableProperty_c;
import org.xtuml.bp.core.ProvidedOperationBody_c;
import org.xtuml.bp.core.ProvidedOperation_c;
import org.xtuml.bp.core.ProvidedSignalBody_c;
import org.xtuml.bp.core.ProvidedSignal_c;
import org.xtuml.bp.core.RequiredExecutableProperty_c;
import org.xtuml.bp.core.RequiredOperationBody_c;
import org.xtuml.bp.core.RequiredOperation_c;
import org.xtuml.bp.core.RequiredSignalBody_c;
import org.xtuml.bp.core.RequiredSignal_c;
import org.xtuml.bp.core.SemEvent_c;
import org.xtuml.bp.core.StateActionBody_c;
import org.xtuml.bp.core.StateEventMatrixEntry_c;
import org.xtuml.bp.core.StateMachineEventDataItem_c;
import org.xtuml.bp.core.StateMachineEvent_c;
import org.xtuml.bp.core.StateMachineState_c;
import org.xtuml.bp.core.SupplementalDataItems_c;
import org.xtuml.bp.core.TransitionActionBody_c;
import org.xtuml.bp.core.TransitionActionHome_c;
import org.xtuml.bp.core.Transition_c;
import org.xtuml.bp.core.common.ClassQueryInterface_c;
import org.xtuml.bp.core.common.NonRootModelElement;
import org.xtuml.bp.core.util.ActionLanguageDescriptionUtil;
import org.xtuml.bp.core.util.DocumentUtil;
import org.xtuml.bp.test.common.BaseTest;
import org.xtuml.bp.test.common.CanvasEditorUtils;
import org.xtuml.bp.test.common.CanvasTestUtils;
import org.xtuml.bp.test.common.ExplorerUtil;
import org.xtuml.bp.test.common.OrderedRunner;
import org.xtuml.bp.test.common.UITestingUtilities;
import org.xtuml.bp.ui.canvas.test.CanvasTest;
import org.xtuml.bp.ui.graphics.editor.GraphicalEditor;
import org.xtuml.bp.ui.text.activity.ActivityEditor;

import junit.framework.TestCase;

@RunWith(OrderedRunner.class)
public class OpenDeclarationsTests extends CanvasTest {
    public static boolean generateResults = false;
    public static boolean useDrawResults = true;
    
    private static IEditorActionDelegate openDeclarationAction;

    String test_id = "";

    protected String getResultName() {
        return getClass().getSimpleName() + "_" + test_id;
    }

    private GraphicalEditor fActiveEditor;
    private NonRootModelElement testBody;
    private Object testElement;
    private NonRootModelElement activityElement;
    private IDocument testDocument;
    private IRegion wordRegion;
    private IRegion cursorPosition;

    protected GraphicalEditor getActiveEditor() {
        return fActiveEditor;
    }

    public OpenDeclarationsTests(String subTypeClassName, String subTypeArg0) {
        super(null, subTypeArg0);
    }

    protected String getTestId(String src, String dest, String count) {
        return "test_" + count;
    }

    @Override
    protected void initialSetup() throws Exception {
    	// load the test model
        loadProject("oal_open_declarations");
        m_sys = getSystemModel("oal_open_declarations");
        modelRoot = Ooaofooa.getInstance("/oal_open_declarations/models/oal_open_declarations/MainPackage/MainPackage.xtuml");
        // use reflection to get the open declaration action
        Class<?> openDeclarationActionClass = Class.forName( "org.xtuml.bp.ui.text.activity.OpenDeclarationAction" );
        if ( null != openDeclarationActionClass ) {
            openDeclarationAction = (IEditorActionDelegate) openDeclarationActionClass.newInstance();
        }
        else openDeclarationAction = null;
    };

    @Before
    public void setUp() throws Exception {
        super.setUp();
        assertNotNull( "Open declarations is not implemented for the OAL editor", openDeclarationAction );
    }

    // example of test name: testT01L01_E01P01M01C01
    private Object getTestElement( String element ) {
        String t = element.substring( 3, 6 );
        String e = element.substring( 6, 9 );
        switch (t) {
        case "T01":
            // return the first Variable location as offset
            String documentText = testDocument.get();
            return documentText.indexOf( t + e );
        case "T02":
            return ModelClass_c.ModelClassInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((ModelClass_c) candidate).getName().equals(t + e);
                }
            });
        case "T03":
            return Function_c.FunctionInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Function_c) candidate).getName().equals(t + e);
                }
            });
        case "T04":
            return ExternalEntity_c.ExternalEntityInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((ExternalEntity_c) candidate).getName().equals(t + e);
                }
            });
        case "T05":
        	// TODO make sure this is in the right component
            return Port_c.PortInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Port_c) candidate).getName().equals(t + e);
                }
            });
        case "T06":
        	// TODO take another look here
            return StateMachineEvent_c.StateMachineEventInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((StateMachineEvent_c) candidate).getMning().equals(t + e);
                }
            });
        case "T07":
            return Operation_c.OperationInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Operation_c) candidate).getName().equals(t + e);
                }
            });
        case "T08":
            return Bridge_c.BridgeInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Bridge_c) candidate).getName().equals(t + e);
                }
            });
        case "T09":
            return InterfaceOperation_c.InterfaceOperationInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((InterfaceOperation_c) candidate).getName().equals(t + e);
                }
            });
        case "T10":
            return InterfaceSignal_c.InterfaceSignalInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((InterfaceSignal_c) candidate).getName().equals(t + e);
                }
            });
        case "T11":
            if (activityElement instanceof Operation_c) {
                return OperationParameter_c.getOneO_TPARMOnR117((Operation_c) activityElement, new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((OperationParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof Bridge_c) {
                return BridgeParameter_c.getOneS_BPARMOnR21((Bridge_c) activityElement, new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((BridgeParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof Function_c) {
                return FunctionParameter_c.getOneS_SPARMOnR24((Function_c) activityElement, new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((FunctionParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof ProvidedSignal_c) {
                return PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4501(
                        ProvidedExecutableProperty_c.getManySPR_PEPsOnR4503((ProvidedSignal_c) activityElement)), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((PropertyParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof ProvidedOperation_c) {
                return PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4501(
                        ProvidedExecutableProperty_c.getManySPR_PEPsOnR4503((ProvidedOperation_c) activityElement)), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((PropertyParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof RequiredSignal_c) {
                return PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4500(
                        RequiredExecutableProperty_c.getManySPR_REPsOnR4502((RequiredSignal_c) activityElement)), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((PropertyParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof RequiredOperation_c) {
                return PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4500(
                        RequiredExecutableProperty_c.getManySPR_REPsOnR4502((RequiredOperation_c) activityElement)), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((PropertyParameter_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof Transition_c) {
                return StateMachineEventDataItem_c.getOneSM_EVTDIOnR522(
                        SupplementalDataItems_c.getManySM_SDIsOnR522(EventSupplementalData_c.getManySM_SUPDTsOnR520(
                                StateMachineEvent_c.getManySM_EVTsOnR525(SemEvent_c.getManySM_SEVTsOnR503(
                                        StateEventMatrixEntry_c.getManySM_SEMEsOnR504(NewStateTransition_c
                                                .getManySM_NSTXNsOnR507((Transition_c) activityElement)))))), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((StateMachineEventDataItem_c) candidate).getName().equals(t + e);
                    }
                });
            }
            if (activityElement instanceof StateMachineState_c) {
                return StateMachineEventDataItem_c.getOneSM_EVTDIOnR522(SupplementalDataItems_c
                        .getManySM_SDIsOnR522(EventSupplementalData_c.getManySM_SUPDTsOnR520(StateMachineEvent_c
                                .getManySM_EVTsOnR525(SemEvent_c.getManySM_SEVTsOnR503(StateEventMatrixEntry_c
                                        .getManySM_SEMEsOnR503((StateMachineState_c) activityElement))))), new ClassQueryInterface_c() {
                    @Override
                    public boolean evaluate(Object candidate) {
                        return ((StateMachineEventDataItem_c) candidate).getName().equals(t + e);
                    }
                });
            }
        case "T12":
        	// in this section, because of the inability to name
        	// relationships freeform, relationships have been
        	// numbered such that in each case, if 'R99' is replaced
        	// by 'T12E', the relationship specification will match
        	// the desired DOF selection
            return Association_c.AssociationInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Association_c) candidate).getNumb() == 9900 + Integer.parseInt(e.substring(1));
                }
            });
        case "T13":
            return Attribute_c.AttributeInstance(modelRoot, new ClassQueryInterface_c() {
                @Override
                public boolean evaluate(Object candidate) {
                    return ((Attribute_c) candidate).getName().equals(t + e);
                }
            });
        default:
            break;
        }
        return null;
    }

    // example of test name: testT01L01_E01P01M01C01
    private NonRootModelElement getActivityElement( String element ) {
        NonRootModelElement activityElement = null;
        final String l = element.substring( 0, 3 );
        switch ( l ) {
            case "L01":
                RequiredSignal_c rs = RequiredSignal_c.RequiredSignalInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((RequiredSignal_c)candidate).getName().equals( l );
					}
                });
                activityElement = rs;
                testBody = Body_c.getOneACT_ACTOnR698(RequiredSignalBody_c.getOneACT_RSBOnR684(rs));
                break;
            case "L02":
                RequiredOperation_c ro = RequiredOperation_c.RequiredOperationInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((RequiredOperation_c)candidate).getName().equals( l );
					}
                });
                activityElement = ro;
                testBody = Body_c.getOneACT_ACTOnR698(RequiredOperationBody_c.getOneACT_ROBOnR685(ro));
                break;
            case "L03":
                ProvidedSignal_c ps = ProvidedSignal_c.ProvidedSignalInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((ProvidedSignal_c)candidate).getName().equals( l );
					}
                });
                activityElement = ps;
                testBody = Body_c.getOneACT_ACTOnR698(ProvidedSignalBody_c.getOneACT_PSBOnR686(ps));
                break;
            case "L04":
                ProvidedOperation_c po = ProvidedOperation_c.ProvidedOperationInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((ProvidedOperation_c)candidate).getName().equals( l );
					}
                });
                activityElement = po;
                testBody = Body_c.getOneACT_ACTOnR698(ProvidedOperationBody_c.getOneACT_POBOnR687(po));
                break;
            case "L05":
                Transition_c transition = Transition_c.TransitionInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((Transition_c)candidate).getName().equals( l );
					}
                });
                activityElement = transition;
                testBody = Body_c.getOneACT_ACTOnR698(TransitionActionBody_c.getManyACT_TABsOnR688(Action_c.getManySM_ACTsOnR514(ActionHome_c.getManySM_AHsOnR513(TransitionActionHome_c.getManySM_TAHsOnR530(transition)))));
                break;
            case "L06":
                StateMachineState_c state = StateMachineState_c.StateMachineStateInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((StateMachineState_c)candidate).getName().equals( l );
					}
                });
                activityElement = state;
                testBody = Body_c.getOneACT_ACTOnR698(StateActionBody_c.getManyACT_SABsOnR691(Action_c.getManySM_ACTsOnR514(ActionHome_c.getManySM_AHsOnR513(MooreActionHome_c.getManySM_MOAHsOnR511(state)))));
                break;
            case "L07":
                DerivedBaseAttribute_c dba = DerivedBaseAttribute_c.DerivedBaseAttributeInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((DerivedBaseAttribute_c)candidate).getName().equals( l );
					}
                });
                activityElement = dba;
                testBody = Body_c.getOneACT_ACTOnR698(DerivedAttributeBody_c.getManyACT_DABsOnR693(dba));
                break;
            case "L08":
                Function_c function = Function_c.FunctionInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((Function_c)candidate).getName().equals( l );
					}
                });
                activityElement = function;
                testBody = Body_c.getOneACT_ACTOnR698(FunctionBody_c.getManyACT_FNBsOnR695(function));
                break;
            case "L09":
                Operation_c operation = Operation_c.OperationInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((Operation_c)candidate).getName().equals( l );
					}
                });
                activityElement = operation;
                testBody = Body_c.getOneACT_ACTOnR698(OperationBody_c.getManyACT_OPBsOnR696(operation));
                break;
            case "L10":
                Bridge_c bridge = Bridge_c.BridgeInstance( modelRoot, new ClassQueryInterface_c() {
					@Override
					public boolean evaluate(Object candidate) {
						return ((Bridge_c)candidate).getName().equals( l );
					}
                });
                activityElement = bridge;
                testBody = Body_c.getOneACT_ACTOnR698(BridgeBody_c.getManyACT_BRBsOnR697(bridge));
                break;
            default:
                break;
        }
        return activityElement;
    }
    
    private IRegion getTestWord( String element ) {
    	// TODO think about T06
    	String documentText = testDocument.get();
    	String t = element.substring( 3, 6 );
    	String e = element.substring( 6, 9 );
    	int commentLine = DocumentUtil.positionToLine( documentText.indexOf( "// " + t + " " + e ), testDocument );
    	String testLine = documentText.substring( DocumentUtil.lineAndColumnToPosition( commentLine + 1, 1, testDocument),
    	                                          DocumentUtil.lineAndColumnToPosition( commentLine + 2, 1, testDocument) );
    	int lineOffset = testLine.indexOf( t + e );
    	return new Region( DocumentUtil.lineAndColumnToPosition( commentLine + 1, 1, testDocument) + lineOffset, (t + e).length() );
    }
    
    private IRegion getCursorPosition( String element, IRegion region ) {
    	if ( element.contains("P01") ) {
    		// set the cursor at the beginning of the word
    		return new Region( region.getOffset(), 0 );
    	}
    	else if ( element.contains("P02") ) {
    		// set the cursor somewhere in the middle of the word
    		return new Region( region.getOffset() + 1, 0 );
    	}
    	else if ( element.contains("P03") ) {
    		// set the cursor at the end of the word
    		return new Region( region.getOffset() + region.getLength(), 0 );
    	}
    	else return null;
    }

    @After
    public void tearDown() throws Exception {
        // close all editors
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
        super.tearDown();
    }

    /**
     * "TL" is one of the degrees of freedom as specified in this issues test
     * matrix. This routine gets the "TL" instance from the given name.
     * 
     * @param element
     *            The degree of freedom instance to retrieve
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectTL(String element) {
        return selectTL(element, null);
    }

    /**
     * "TL" is one of the degrees of freedom as specified in this issues test
     * matrix. This routine gets the "TL" instance from the given name.
     * 
     * @param element
     *            The degree of freedom instance to retrieve
     * @param extraData
     *            Extra data needed for selection
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectTL(String element, Object extraData) {
    	// get the activity element and body from the L value
        activityElement = getActivityElement( element );
        assertNotNull("Could not locate test body.", activityElement);
        testDocument = new Document(ActionLanguageDescriptionUtil.getActionLanguageAttributeValue(activityElement));
        wordRegion = getTestWord( element );
        // get the test element from the T and E values
        testElement = getTestElement( element );
        assertNotNull("Could not locate test element.", testElement);
        return null;
    }

    /**
     * "EPMC" is one of the degrees of freedom as specified in this issues test
     * matrix. This routine gets the "EPMC" instance from the given name.
     * 
     * @param element
     *            The degree of freedom instance to retrieve
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectEPMC(String element) {
        return selectEPMC(element, null);
    }

    /**
     * "EPMC" is one of the degrees of freedom as specified in this issues test
     * matrix. This routine gets the "EPMC" instance from the given name.
     * 
     * @param element
     *            The degree of freedom instance to retrieve
     * @param extraData
     *            Extra data needed for selection
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectEPMC(String element, Object extraData) {
    	// get the cursor position in the document based on the P value and selected test word
    	cursorPosition = getCursorPosition( element, wordRegion );
    	// set up model explorer based on the M value
        setupModelExplorer( element );
        // set up the canvas based on the C value
        setupCanvas( element );
        return null;
    }

    /**
     * This routine performs the action associated with a matrix cell. The
     * parameters represent model instances aquired based on the specifed column
     * instance and row instance.
     * 
     * @param columnInstance
     *            Model instance from the column
     * @param rowInstance
     *            Model instance from the row
     */
    void TL_EPMC_Action(NonRootModelElement columnInstance, NonRootModelElement rowInstance) {
    	// make sure the activity editor is open
        CanvasTestUtils.openActivityEditor(activityElement);
        // get editor and set cursor position
        ActivityEditor editor = (ActivityEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        editor.getTextViewer().setSelection(new TextSelection(cursorPosition.getOffset(), cursorPosition.getLength()));
        // execute the open declaration action
        openDeclarationAction.setActiveEditor(null, PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
        openDeclarationAction.run(null);
    }

    private void setupCanvas( String element ) {
        if (element.contains("C2")) {
            // open the canvas editor for this test
            fActiveEditor = CanvasEditorUtils.openEditorWithShapeOf(testBody);
        } else {
            // nothing to do as the tear down makes sure
            // only the editor for the OAL is opened
        }
    }

    private void setupModelExplorer( String element ) {
        if (element.contains("M2")) {
            // open model explorer view
            try {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .showView("org.xtuml.bp.ui.explorer.ExplorerView");
            } catch (PartInitException e) {
                TestCase.fail("Unable to open Model Explorer.");
            }
        } else {
            // nothing to do as the tear down makes sure
            // only the editor for the OAL is opened
        }
    }

    /**
     * This function verifies an expected result.
     *
     * @param source
     *            A model element instance aquired through a action taken on a
     *            column of the matrix.
     * @param destination
     *            A model element instance aquired through a action taken taken
     *            on a row of the matrix.
     * @return true if the test succeeds, false if it fails
     */
    boolean checkResult_elementShownInMEandCanvas(NonRootModelElement source, NonRootModelElement destination) {
        BaseTest.dispatchEvents();
        // locate selection in ME, assure diagram is opened
        boolean diagramOpened = getActiveEditor() != null && getActiveEditor() instanceof GraphicalEditor;
        if(!diagramOpened) {
            return false;
        }
        IStructuredSelection selection = ((StructuredSelection) ExplorerUtil.getTreeViewer().getSelection());
        IStructuredSelection canvasSelection = ((StructuredSelection) UITestingUtilities.getActiveEditor().getSite()
                .getSelectionProvider().getSelection());
        return selection.getFirstElement() == testElement && canvasSelection.getFirstElement() == testElement;
    }

    /**
     * This function verifies an expected result.
     *
     * @param source
     *            A model element instance aquired through a action taken on a
     *            column of the matrix.
     * @param destination
     *            A model element instance aquired through a action taken taken
     *            on a row of the matrix.
     * @return true if the test succeeds, false if it fails
     */
    boolean checkResult_transientDeclarationShown(NonRootModelElement source, NonRootModelElement destination) {
        BaseTest.dispatchEvents();
        ActivityEditor editor = (ActivityEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
        if ( testElement instanceof Integer ) {
        	return ((Integer)testElement).equals(selection.getOffset());
        }
        else return false;
    }

    /**
     * This function verifies an expected result.
     *
     * @param source
     *            A model element instance aquired through a action taken on a
     *            column of the matrix.
     * @param destination
     *            A model element instance aquired through a action taken taken
     *            on a row of the matrix.
     * @return true if the test succeeds, false if it fails
     */
    boolean checkResult_elementShownInMENotCanvas(NonRootModelElement source, NonRootModelElement destination) {
        BaseTest.dispatchEvents();
        // locate selection in ME, assure no diagram is opened
        boolean diagramOpened = getActiveEditor() != null && (getActiveEditor() instanceof GraphicalEditor);
        if(diagramOpened) {
            return false;
        }
        IStructuredSelection selection = ((StructuredSelection) ExplorerUtil.getTreeViewer().getSelection());
        return selection.getFirstElement() == testElement;
    }

    /**
     * This function verifies an expected result.
     *
     * @param source
     *            A model element instance aquired through a action taken on a
     *            column of the matrix.
     * @param destination
     *            A model element instance aquired through a action taken taken
     *            on a row of the matrix.
     * @return true if the test succeeds, false if it fails
     */
    boolean checkResult_elementShownInCanvasNotME(NonRootModelElement source, NonRootModelElement destination) {
        BaseTest.dispatchEvents();
        // locate selection in ME, assure no diagram is opened
        boolean diagramOpened = getActiveEditor() != null && getActiveEditor() instanceof GraphicalEditor;
        if (!diagramOpened) {
            return false;
        }
        IStructuredSelection selection = ((StructuredSelection) UITestingUtilities.getActiveEditor().getSite()
                .getSelectionProvider().getSelection());
        return selection.getFirstElement() == testElement;
    }

    /**
     * This function verifies an expected result.
     *
     * @param source
     *            A model element instance aquired through a action taken on a
     *            column of the matrix.
     * @param destination
     *            A model element instance aquired through a action taken taken
     *            on a row of the matrix.
     * @return true if the test succeeds, false if it fails
     */
    boolean checkResult_invalidSelection(NonRootModelElement source, NonRootModelElement destination) {
        BaseTest.dispatchEvents();
        // no selection should be made in either canvas or ME
        // locate selection in ME, assure no diagram is opened
        boolean diagramNotOpened = getActiveEditor() == null && !(getActiveEditor() instanceof GraphicalEditor);
        if(!diagramNotOpened) {
            return false;
        }
        IStructuredSelection selection = ((StructuredSelection) ExplorerUtil.getTreeViewer().getSelection());
        return selection.getFirstElement() != testElement;

    }

}
