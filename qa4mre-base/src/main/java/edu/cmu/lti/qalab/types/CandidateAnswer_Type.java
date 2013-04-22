
/* First created by JCasGen Tue Apr 02 22:33:34 EDT 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Apr 22 01:17:03 EDT 2013
 * @generated */
public class CandidateAnswer_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CandidateAnswer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CandidateAnswer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CandidateAnswer(addr, CandidateAnswer_Type.this);
  			   CandidateAnswer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CandidateAnswer(addr, CandidateAnswer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CandidateAnswer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qalab.types.CandidateAnswer");
 
  /** @generated */
  final Feature casFeat_qId;
  /** @generated */
  final int     casFeatCode_qId;
  /** @generated */ 
  public String getQId(int addr) {
        if (featOkTst && casFeat_qId == null)
      jcas.throwFeatMissing("qId", "edu.cmu.lti.qalab.types.CandidateAnswer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_qId);
  }
  /** @generated */    
  public void setQId(int addr, String v) {
        if (featOkTst && casFeat_qId == null)
      jcas.throwFeatMissing("qId", "edu.cmu.lti.qalab.types.CandidateAnswer");
    ll_cas.ll_setStringValue(addr, casFeatCode_qId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.CandidateAnswer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.CandidateAnswer");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_choiceIndex;
  /** @generated */
  final int     casFeatCode_choiceIndex;
  /** @generated */ 
  public int getChoiceIndex(int addr) {
        if (featOkTst && casFeat_choiceIndex == null)
      jcas.throwFeatMissing("choiceIndex", "edu.cmu.lti.qalab.types.CandidateAnswer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_choiceIndex);
  }
  /** @generated */    
  public void setChoiceIndex(int addr, int v) {
        if (featOkTst && casFeat_choiceIndex == null)
      jcas.throwFeatMissing("choiceIndex", "edu.cmu.lti.qalab.types.CandidateAnswer");
    ll_cas.ll_setIntValue(addr, casFeatCode_choiceIndex, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.qalab.types.CandidateAnswer");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.qalab.types.CandidateAnswer");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CandidateAnswer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_qId = jcas.getRequiredFeatureDE(casType, "qId", "uima.cas.String", featOkTst);
    casFeatCode_qId  = (null == casFeat_qId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_qId).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_choiceIndex = jcas.getRequiredFeatureDE(casType, "choiceIndex", "uima.cas.Integer", featOkTst);
    casFeatCode_choiceIndex  = (null == casFeat_choiceIndex) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_choiceIndex).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

  }
}



    