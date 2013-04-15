

/* First created by JCasGen Mon Mar 25 03:46:07 EDT 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Apr 14 21:09:16 EDT 2013
 * XML source: /home/yibinl/workspace2/tmp_yibin/kartik_lab/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class CandidateSentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CandidateSentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CandidateSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CandidateSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CandidateSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public CandidateSentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: relevanceScore

  /** getter for relevanceScore - gets 
   * @generated */
  public double getRelevanceScore() {
    if (CandidateSentence_Type.featOkTst && ((CandidateSentence_Type)jcasType).casFeat_relevanceScore == null)
      jcasType.jcas.throwFeatMissing("relevanceScore", "edu.cmu.lti.qalab.types.CandidateSentence");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((CandidateSentence_Type)jcasType).casFeatCode_relevanceScore);}
    
  /** setter for relevanceScore - sets  
   * @generated */
  public void setRelevanceScore(double v) {
    if (CandidateSentence_Type.featOkTst && ((CandidateSentence_Type)jcasType).casFeat_relevanceScore == null)
      jcasType.jcas.throwFeatMissing("relevanceScore", "edu.cmu.lti.qalab.types.CandidateSentence");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((CandidateSentence_Type)jcasType).casFeatCode_relevanceScore, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated */
  public Sentence getSentence() {
    if (CandidateSentence_Type.featOkTst && ((CandidateSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.lti.qalab.types.CandidateSentence");
    return (Sentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CandidateSentence_Type)jcasType).casFeatCode_sentence)));}
    
  /** setter for sentence - sets  
   * @generated */
  public void setSentence(Sentence v) {
    if (CandidateSentence_Type.featOkTst && ((CandidateSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.cmu.lti.qalab.types.CandidateSentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((CandidateSentence_Type)jcasType).casFeatCode_sentence, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    