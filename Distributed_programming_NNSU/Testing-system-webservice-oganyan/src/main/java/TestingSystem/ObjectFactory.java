
package TestingSystem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the TestingSystem package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddAnswersToQuestion_QNAME = new QName("http://Server/", "AddAnswersToQuestion");
    private final static QName _AddAnswersToQuestionResponse_QNAME = new QName("http://Server/", "AddAnswersToQuestionResponse");
    private final static QName _AddNewTask_QNAME = new QName("http://Server/", "AddNewTask");
    private final static QName _AddNewTaskResponse_QNAME = new QName("http://Server/", "AddNewTaskResponse");
    private final static QName _CreateTest_QNAME = new QName("http://Server/", "CreateTest");
    private final static QName _CreateTestResponse_QNAME = new QName("http://Server/", "CreateTestResponse");
    private final static QName _FinishTest_QNAME = new QName("http://Server/", "FinishTest");
    private final static QName _FinishTestResponse_QNAME = new QName("http://Server/", "FinishTestResponse");
    private final static QName _GetNextQuestionOfTest_QNAME = new QName("http://Server/", "GetNextQuestionOfTest");
    private final static QName _GetNextQuestionOfTestResponse_QNAME = new QName("http://Server/", "GetNextQuestionOfTestResponse");
    private final static QName _GetPoints_QNAME = new QName("http://Server/", "GetPoints");
    private final static QName _GetPointsResponse_QNAME = new QName("http://Server/", "GetPointsResponse");
    private final static QName _GetTestsList_QNAME = new QName("http://Server/", "GetTestsList");
    private final static QName _GetTestsListResponse_QNAME = new QName("http://Server/", "GetTestsListResponse");
    private final static QName _ProcessTheAnswer_QNAME = new QName("http://Server/", "ProcessTheAnswer");
    private final static QName _ProcessTheAnswerResponse_QNAME = new QName("http://Server/", "ProcessTheAnswerResponse");
    private final static QName _StartTest_QNAME = new QName("http://Server/", "StartTest");
    private final static QName _StartTestResponse_QNAME = new QName("http://Server/", "StartTestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: TestingSystem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IntArray }
     * 
     */
    public IntArray createIntArray() {
        return new IntArray();
    }

    /**
     * Create an instance of {@link AddAnswersToQuestion }
     * 
     */
    public AddAnswersToQuestion createAddAnswersToQuestion() {
        return new AddAnswersToQuestion();
    }

    /**
     * Create an instance of {@link AddAnswersToQuestionResponse }
     * 
     */
    public AddAnswersToQuestionResponse createAddAnswersToQuestionResponse() {
        return new AddAnswersToQuestionResponse();
    }

    /**
     * Create an instance of {@link AddNewTask }
     * 
     */
    public AddNewTask createAddNewTask() {
        return new AddNewTask();
    }

    /**
     * Create an instance of {@link AddNewTaskResponse }
     * 
     */
    public AddNewTaskResponse createAddNewTaskResponse() {
        return new AddNewTaskResponse();
    }

    /**
     * Create an instance of {@link CreateTest }
     * 
     */
    public CreateTest createCreateTest() {
        return new CreateTest();
    }

    /**
     * Create an instance of {@link CreateTestResponse }
     * 
     */
    public CreateTestResponse createCreateTestResponse() {
        return new CreateTestResponse();
    }

    /**
     * Create an instance of {@link FinishTest }
     * 
     */
    public FinishTest createFinishTest() {
        return new FinishTest();
    }

    /**
     * Create an instance of {@link FinishTestResponse }
     * 
     */
    public FinishTestResponse createFinishTestResponse() {
        return new FinishTestResponse();
    }

    /**
     * Create an instance of {@link GetNextQuestionOfTest }
     * 
     */
    public GetNextQuestionOfTest createGetNextQuestionOfTest() {
        return new GetNextQuestionOfTest();
    }

    /**
     * Create an instance of {@link GetNextQuestionOfTestResponse }
     * 
     */
    public GetNextQuestionOfTestResponse createGetNextQuestionOfTestResponse() {
        return new GetNextQuestionOfTestResponse();
    }

    /**
     * Create an instance of {@link GetPoints }
     * 
     */
    public GetPoints createGetPoints() {
        return new GetPoints();
    }

    /**
     * Create an instance of {@link GetPointsResponse }
     * 
     */
    public GetPointsResponse createGetPointsResponse() {
        return new GetPointsResponse();
    }

    /**
     * Create an instance of {@link GetTestsList }
     * 
     */
    public GetTestsList createGetTestsList() {
        return new GetTestsList();
    }

    /**
     * Create an instance of {@link GetTestsListResponse }
     * 
     */
    public GetTestsListResponse createGetTestsListResponse() {
        return new GetTestsListResponse();
    }

    /**
     * Create an instance of {@link ProcessTheAnswer }
     * 
     */
    public ProcessTheAnswer createProcessTheAnswer() {
        return new ProcessTheAnswer();
    }

    /**
     * Create an instance of {@link ProcessTheAnswerResponse }
     * 
     */
    public ProcessTheAnswerResponse createProcessTheAnswerResponse() {
        return new ProcessTheAnswerResponse();
    }

    /**
     * Create an instance of {@link StartTest }
     * 
     */
    public StartTest createStartTest() {
        return new StartTest();
    }

    /**
     * Create an instance of {@link StartTestResponse }
     * 
     */
    public StartTestResponse createStartTestResponse() {
        return new StartTestResponse();
    }

    /**
     * Create an instance of {@link DataNextQuestion }
     * 
     */
    public DataNextQuestion createDataNextQuestion() {
        return new DataNextQuestion();
    }

    /**
     * Create an instance of {@link PairStringInt }
     * 
     */
    public PairStringInt createPairStringInt() {
        return new PairStringInt();
    }

    /**
     * Create an instance of {@link PairTestId }
     * 
     */
    public PairTestId createPairTestId() {
        return new PairTestId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswersToQuestion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAnswersToQuestion }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "AddAnswersToQuestion")
    public JAXBElement<AddAnswersToQuestion> createAddAnswersToQuestion(AddAnswersToQuestion value) {
        return new JAXBElement<AddAnswersToQuestion>(_AddAnswersToQuestion_QNAME, AddAnswersToQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswersToQuestionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAnswersToQuestionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "AddAnswersToQuestionResponse")
    public JAXBElement<AddAnswersToQuestionResponse> createAddAnswersToQuestionResponse(AddAnswersToQuestionResponse value) {
        return new JAXBElement<AddAnswersToQuestionResponse>(_AddAnswersToQuestionResponse_QNAME, AddAnswersToQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewTask }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewTask }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "AddNewTask")
    public JAXBElement<AddNewTask> createAddNewTask(AddNewTask value) {
        return new JAXBElement<AddNewTask>(_AddNewTask_QNAME, AddNewTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewTaskResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewTaskResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "AddNewTaskResponse")
    public JAXBElement<AddNewTaskResponse> createAddNewTaskResponse(AddNewTaskResponse value) {
        return new JAXBElement<AddNewTaskResponse>(_AddNewTaskResponse_QNAME, AddNewTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateTest }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "CreateTest")
    public JAXBElement<CreateTest> createCreateTest(CreateTest value) {
        return new JAXBElement<CreateTest>(_CreateTest_QNAME, CreateTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateTestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "CreateTestResponse")
    public JAXBElement<CreateTestResponse> createCreateTestResponse(CreateTestResponse value) {
        return new JAXBElement<CreateTestResponse>(_CreateTestResponse_QNAME, CreateTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishTest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FinishTest }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "FinishTest")
    public JAXBElement<FinishTest> createFinishTest(FinishTest value) {
        return new JAXBElement<FinishTest>(_FinishTest_QNAME, FinishTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishTestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FinishTestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "FinishTestResponse")
    public JAXBElement<FinishTestResponse> createFinishTestResponse(FinishTestResponse value) {
        return new JAXBElement<FinishTestResponse>(_FinishTestResponse_QNAME, FinishTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNextQuestionOfTest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetNextQuestionOfTest }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetNextQuestionOfTest")
    public JAXBElement<GetNextQuestionOfTest> createGetNextQuestionOfTest(GetNextQuestionOfTest value) {
        return new JAXBElement<GetNextQuestionOfTest>(_GetNextQuestionOfTest_QNAME, GetNextQuestionOfTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNextQuestionOfTestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetNextQuestionOfTestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetNextQuestionOfTestResponse")
    public JAXBElement<GetNextQuestionOfTestResponse> createGetNextQuestionOfTestResponse(GetNextQuestionOfTestResponse value) {
        return new JAXBElement<GetNextQuestionOfTestResponse>(_GetNextQuestionOfTestResponse_QNAME, GetNextQuestionOfTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoints }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPoints }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetPoints")
    public JAXBElement<GetPoints> createGetPoints(GetPoints value) {
        return new JAXBElement<GetPoints>(_GetPoints_QNAME, GetPoints.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPointsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPointsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetPointsResponse")
    public JAXBElement<GetPointsResponse> createGetPointsResponse(GetPointsResponse value) {
        return new JAXBElement<GetPointsResponse>(_GetPointsResponse_QNAME, GetPointsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestsList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTestsList }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetTestsList")
    public JAXBElement<GetTestsList> createGetTestsList(GetTestsList value) {
        return new JAXBElement<GetTestsList>(_GetTestsList_QNAME, GetTestsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTestsListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTestsListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "GetTestsListResponse")
    public JAXBElement<GetTestsListResponse> createGetTestsListResponse(GetTestsListResponse value) {
        return new JAXBElement<GetTestsListResponse>(_GetTestsListResponse_QNAME, GetTestsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessTheAnswer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProcessTheAnswer }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "ProcessTheAnswer")
    public JAXBElement<ProcessTheAnswer> createProcessTheAnswer(ProcessTheAnswer value) {
        return new JAXBElement<ProcessTheAnswer>(_ProcessTheAnswer_QNAME, ProcessTheAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessTheAnswerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProcessTheAnswerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "ProcessTheAnswerResponse")
    public JAXBElement<ProcessTheAnswerResponse> createProcessTheAnswerResponse(ProcessTheAnswerResponse value) {
        return new JAXBElement<ProcessTheAnswerResponse>(_ProcessTheAnswerResponse_QNAME, ProcessTheAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartTest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StartTest }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "StartTest")
    public JAXBElement<StartTest> createStartTest(StartTest value) {
        return new JAXBElement<StartTest>(_StartTest_QNAME, StartTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartTestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StartTestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "StartTestResponse")
    public JAXBElement<StartTestResponse> createStartTestResponse(StartTestResponse value) {
        return new JAXBElement<StartTestResponse>(_StartTestResponse_QNAME, StartTestResponse.class, null, value);
    }

}
