

/* First created by JCasGen Sat Feb 09 14:12:08 EST 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** After removal of noise from corpus
 * Updated by JCasGen Sat Feb 09 14:27:07 EST 2013
 * XML source: /media/alkesh/Windows7_OS/Users/alkesh/git/qalabcmu/qa4mre-corpus-annotation/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class FilteredDocument extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FilteredDocument.class);
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
  protected FilteredDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FilteredDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FilteredDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FilteredDocument(JCas jcas, int begin, int end) {
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
    if (FilteredDocument_Type.featOkTst && ((FilteredDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.FilteredDocument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FilteredDocument_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (FilteredDocument_Type.featOkTst && ((FilteredDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.FilteredDocument");
    jcasType.ll_cas.ll_setStringValue(addr, ((FilteredDocument_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (FilteredDocument_Type.featOkTst && ((FilteredDocument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.FilteredDocument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FilteredDocument_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (FilteredDocument_Type.featOkTst && ((FilteredDocument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.FilteredDocument");
    jcasType.ll_cas.ll_setStringValue(addr, ((FilteredDocument_Type)jcasType).casFeatCode_id, v);}    
  }

    