
/* First created by JCasGen Sun Feb 03 13:01:15 EST 2013 */
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
 * Updated by JCasGen Wed Feb 20 04:59:42 EST 2013
 * @generated */
public class SourceDocument_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SourceDocument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SourceDocument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SourceDocument(addr, SourceDocument_Type.this);
  			   SourceDocument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SourceDocument(addr, SourceDocument_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SourceDocument.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qalab.types.SourceDocument");
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_filteredText;
  /** @generated */
  final int     casFeatCode_filteredText;
  /** @generated */ 
  public String getFilteredText(int addr) {
        if (featOkTst && casFeat_filteredText == null)
      jcas.throwFeatMissing("filteredText", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_filteredText);
  }
  /** @generated */    
  public void setFilteredText(int addr, String v) {
        if (featOkTst && casFeat_filteredText == null)
      jcas.throwFeatMissing("filteredText", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setStringValue(addr, casFeatCode_filteredText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentenceList;
  /** @generated */
  final int     casFeatCode_sentenceList;
  /** @generated */ 
  public int getSentenceList(int addr) {
        if (featOkTst && casFeat_sentenceList == null)
      jcas.throwFeatMissing("sentenceList", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sentenceList);
  }
  /** @generated */    
  public void setSentenceList(int addr, int v) {
        if (featOkTst && casFeat_sentenceList == null)
      jcas.throwFeatMissing("sentenceList", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_sentenceList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_phraseList;
  /** @generated */
  final int     casFeatCode_phraseList;
  /** @generated */ 
  public int getPhraseList(int addr) {
        if (featOkTst && casFeat_phraseList == null)
      jcas.throwFeatMissing("phraseList", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_phraseList);
  }
  /** @generated */    
  public void setPhraseList(int addr, int v) {
        if (featOkTst && casFeat_phraseList == null)
      jcas.throwFeatMissing("phraseList", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_phraseList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nerList;
  /** @generated */
  final int     casFeatCode_nerList;
  /** @generated */ 
  public int getNerList(int addr) {
        if (featOkTst && casFeat_nerList == null)
      jcas.throwFeatMissing("nerList", "edu.cmu.lti.qalab.types.SourceDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_nerList);
  }
  /** @generated */    
  public void setNerList(int addr, int v) {
        if (featOkTst && casFeat_nerList == null)
      jcas.throwFeatMissing("nerList", "edu.cmu.lti.qalab.types.SourceDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_nerList, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SourceDocument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_filteredText = jcas.getRequiredFeatureDE(casType, "filteredText", "uima.cas.String", featOkTst);
    casFeatCode_filteredText  = (null == casFeat_filteredText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_filteredText).getCode();

 
    casFeat_sentenceList = jcas.getRequiredFeatureDE(casType, "sentenceList", "uima.cas.FSList", featOkTst);
    casFeatCode_sentenceList  = (null == casFeat_sentenceList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceList).getCode();

 
    casFeat_phraseList = jcas.getRequiredFeatureDE(casType, "phraseList", "uima.cas.FSList", featOkTst);
    casFeatCode_phraseList  = (null == casFeat_phraseList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_phraseList).getCode();

 
    casFeat_nerList = jcas.getRequiredFeatureDE(casType, "nerList", "uima.cas.FSList", featOkTst);
    casFeatCode_nerList  = (null == casFeat_nerList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nerList).getCode();

  }
}



    