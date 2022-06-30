
package TestingSystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataNextQuestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataNextQuestion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="answers" type="{http://Server/}pairStringInt" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id_question" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="question" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataNextQuestion", propOrder = {
    "answers",
    "idQuestion",
    "question"
})
public class DataNextQuestion {

    @XmlElement(nillable = true)
    protected List<PairStringInt> answers;
    @XmlElement(name = "id_question")
    protected int idQuestion;
    protected String question;

    /**
     * Gets the value of the answers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PairStringInt }
     * 
     * 
     */
    public List<PairStringInt> getAnswers() {
        if (answers == null) {
            answers = new ArrayList<PairStringInt>();
        }
        return this.answers;
    }

    /**
     * Gets the value of the idQuestion property.
     * 
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * Sets the value of the idQuestion property.
     * 
     */
    public void setIdQuestion(int value) {
        this.idQuestion = value;
    }

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestion(String value) {
        this.question = value;
    }

}
