
package TestingSystem;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TestingSystem", targetNamespace = "http://Server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TestingSystem {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "AddAnswersToQuestion")
    @RequestWrapper(localName = "AddAnswersToQuestion", targetNamespace = "http://Server/", className = "TestingSystem.AddAnswersToQuestion")
    @ResponseWrapper(localName = "AddAnswersToQuestionResponse", targetNamespace = "http://Server/", className = "TestingSystem.AddAnswersToQuestionResponse")
    @Action(input = "http://Server/TestingSystem/AddAnswersToQuestionRequest", output = "http://Server/TestingSystem/AddAnswersToQuestionResponse")
    public void addAnswersToQuestion(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        List<Boolean> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        List<IntArray> arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns TestingSystem.DataNextQuestion
     */
    @WebMethod(operationName = "GetNextQuestionOfTest")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetNextQuestionOfTest", targetNamespace = "http://Server/", className = "TestingSystem.GetNextQuestionOfTest")
    @ResponseWrapper(localName = "GetNextQuestionOfTestResponse", targetNamespace = "http://Server/", className = "TestingSystem.GetNextQuestionOfTestResponse")
    @Action(input = "http://Server/TestingSystem/GetNextQuestionOfTestRequest", output = "http://Server/TestingSystem/GetNextQuestionOfTestResponse")
    public DataNextQuestion getNextQuestionOfTest(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CreateTest")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CreateTest", targetNamespace = "http://Server/", className = "TestingSystem.CreateTest")
    @ResponseWrapper(localName = "CreateTestResponse", targetNamespace = "http://Server/", className = "TestingSystem.CreateTestResponse")
    @Action(input = "http://Server/TestingSystem/CreateTestRequest", output = "http://Server/TestingSystem/CreateTestResponse")
    public int createTest(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<TestingSystem.PairTestId>
     */
    @WebMethod(operationName = "GetTestsList")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetTestsList", targetNamespace = "http://Server/", className = "TestingSystem.GetTestsList")
    @ResponseWrapper(localName = "GetTestsListResponse", targetNamespace = "http://Server/", className = "TestingSystem.GetTestsListResponse")
    @Action(input = "http://Server/TestingSystem/GetTestsListRequest", output = "http://Server/TestingSystem/GetTestsListResponse")
    public List<PairTestId> getTestsList();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod(operationName = "AddNewTask")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "AddNewTask", targetNamespace = "http://Server/", className = "TestingSystem.AddNewTask")
    @ResponseWrapper(localName = "AddNewTaskResponse", targetNamespace = "http://Server/", className = "TestingSystem.AddNewTaskResponse")
    @Action(input = "http://Server/TestingSystem/AddNewTaskRequest", output = "http://Server/TestingSystem/AddNewTaskResponse")
    public int addNewTask(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod(operationName = "StartTest")
    @RequestWrapper(localName = "StartTest", targetNamespace = "http://Server/", className = "TestingSystem.StartTest")
    @ResponseWrapper(localName = "StartTestResponse", targetNamespace = "http://Server/", className = "TestingSystem.StartTestResponse")
    @Action(input = "http://Server/TestingSystem/StartTestRequest", output = "http://Server/TestingSystem/StartTestResponse")
    public void startTest(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "ProcessTheAnswer")
    @RequestWrapper(localName = "ProcessTheAnswer", targetNamespace = "http://Server/", className = "TestingSystem.ProcessTheAnswer")
    @ResponseWrapper(localName = "ProcessTheAnswerResponse", targetNamespace = "http://Server/", className = "TestingSystem.ProcessTheAnswerResponse")
    @Action(input = "http://Server/TestingSystem/ProcessTheAnswerRequest", output = "http://Server/TestingSystem/ProcessTheAnswerResponse")
    public void processTheAnswer(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<Integer> arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GetPoints")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetPoints", targetNamespace = "http://Server/", className = "TestingSystem.GetPoints")
    @ResponseWrapper(localName = "GetPointsResponse", targetNamespace = "http://Server/", className = "TestingSystem.GetPointsResponse")
    @Action(input = "http://Server/TestingSystem/GetPointsRequest", output = "http://Server/TestingSystem/GetPointsResponse")
    public int getPoints(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod(operationName = "FinishTest")
    @RequestWrapper(localName = "FinishTest", targetNamespace = "http://Server/", className = "TestingSystem.FinishTest")
    @ResponseWrapper(localName = "FinishTestResponse", targetNamespace = "http://Server/", className = "TestingSystem.FinishTestResponse")
    @Action(input = "http://Server/TestingSystem/FinishTestRequest", output = "http://Server/TestingSystem/FinishTestResponse")
    public void finishTest(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
