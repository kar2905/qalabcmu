

/* First created by JCasGen Sat Feb 09 22:35:48 EST 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Feb 09 22:36:15 EST 2013
 * XML source: /media/alkesh/Windows7_OS/Users/alkesh/git/qalabcmu/qa4mre-corpus-annotation/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class Dependency extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Dependency.class);
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
  protected Dependency() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Dependency(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Dependency(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Dependency(JCas jcas, int begin, int end) {
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
  //* Feature: governor

  /** getter for governor - gets 
   * @generated */
  public String getGovernor() {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_governor == null)
      jcasType.jcas.throwFeatMissing("governor", "edu.cmu.lti.qalab.types.Dependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_governor);}
    
  /** setter for governor - sets  
   * @generated */
  public void setGovernor(String v) {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_governor == null)
      jcasType.jcas.throwFeatMissing("governor", "edu.cmu.lti.qalab.types.Dependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_governor, v);}    
   
    
  //*--------------*
  //* Feature: dependent

  /** getter for dependent - gets 
   * @generated */
  public String getDependent() {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_dependent == null)
      jcasType.jcas.throwFeatMissing("dependent", "edu.cmu.lti.qalab.types.Dependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_dependent);}
    
  /** setter for dependent - sets  
   * @generated */
  public void setDependent(String v) {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_dependent == null)
      jcasType.jcas.throwFeatMissing("dependent", "edu.cmu.lti.qalab.types.Dependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_dependent, v);}    
   
    
  //*--------------*
  //* Feature: relation

  /** getter for relation - gets 
   * @generated */
  public String getRelation() {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.cmu.lti.qalab.types.Dependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_relation);}
    
  /** setter for relation - sets  
   * @generated */
  public void setRelation(String v) {
    if (Dependency_Type.featOkTst && ((Dependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.cmu.lti.qalab.types.Dependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dependency_Type)jcasType).casFeatCode_relation, v);}    
  }

    