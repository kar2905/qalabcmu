

/* First created by JCasGen Sat Feb 09 19:02:34 EST 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Feb 09 22:36:15 EST 2013
 * XML source: /media/alkesh/Windows7_OS/Users/alkesh/git/qalabcmu/qa4mre-corpus-annotation/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class Phrase extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Phrase.class);
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
  protected Phrase() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Phrase(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Phrase(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Phrase(JCas jcas, int begin, int end) {
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
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (Phrase_Type.featOkTst && ((Phrase_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.Phrase");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Phrase_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (Phrase_Type.featOkTst && ((Phrase_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.Phrase");
    jcasType.ll_cas.ll_setStringValue(addr, ((Phrase_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: weight

  /** getter for weight - gets 
   * @generated */
  public double getWeight() {
    if (Phrase_Type.featOkTst && ((Phrase_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.qalab.types.Phrase");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Phrase_Type)jcasType).casFeatCode_weight);}
    
  /** setter for weight - sets  
   * @generated */
  public void setWeight(double v) {
    if (Phrase_Type.featOkTst && ((Phrase_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.qalab.types.Phrase");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Phrase_Type)jcasType).casFeatCode_weight, v);}    
  }

    