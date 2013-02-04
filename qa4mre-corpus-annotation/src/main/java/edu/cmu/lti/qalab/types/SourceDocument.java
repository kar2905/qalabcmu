

/* First created by JCasGen Sun Feb 03 13:01:15 EST 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Feb 03 13:05:01 EST 2013
 * XML source: /media/alkesh/Windows7_OS/Users/alkesh/workspace/qa4mre-corpus-annotation/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class SourceDocument extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SourceDocument.class);
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
  protected SourceDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SourceDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SourceDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SourceDocument(JCas jcas, int begin, int end) {
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
    if (SourceDocument_Type.featOkTst && ((SourceDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.SourceDocument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceDocument_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (SourceDocument_Type.featOkTst && ((SourceDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.SourceDocument");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceDocument_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (SourceDocument_Type.featOkTst && ((SourceDocument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.SourceDocument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceDocument_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (SourceDocument_Type.featOkTst && ((SourceDocument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.SourceDocument");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceDocument_Type)jcasType).casFeatCode_id, v);}    
  }

    