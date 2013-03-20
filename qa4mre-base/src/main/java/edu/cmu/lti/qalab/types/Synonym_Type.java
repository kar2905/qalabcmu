
/* First created by JCasGen Wed Feb 20 04:59:42 EST 2013 */
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
 * Updated by JCasGen Wed Mar 13 13:14:06 EDT 2013
 * @generated */
public class Synonym_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Synonym_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Synonym_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Synonym(addr, Synonym_Type.this);
  			   Synonym_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Synonym(addr, Synonym_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Synonym.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qalab.types.Synonym");
 
  /** @generated */
  final Feature casFeat_synList;
  /** @generated */
  final int     casFeatCode_synList;
  /** @generated */ 
  public int getSynList(int addr) {
        if (featOkTst && casFeat_synList == null)
      jcas.throwFeatMissing("synList", "edu.cmu.lti.qalab.types.Synonym");
    return ll_cas.ll_getRefValue(addr, casFeatCode_synList);
  }
  /** @generated */    
  public void setSynList(int addr, int v) {
        if (featOkTst && casFeat_synList == null)
      jcas.throwFeatMissing("synList", "edu.cmu.lti.qalab.types.Synonym");
    ll_cas.ll_setRefValue(addr, casFeatCode_synList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_source;
  /** @generated */
  final int     casFeatCode_source;
  /** @generated */ 
  public String getSource(int addr) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "edu.cmu.lti.qalab.types.Synonym");
    return ll_cas.ll_getStringValue(addr, casFeatCode_source);
  }
  /** @generated */    
  public void setSource(int addr, String v) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "edu.cmu.lti.qalab.types.Synonym");
    ll_cas.ll_setStringValue(addr, casFeatCode_source, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Synonym_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_synList = jcas.getRequiredFeatureDE(casType, "synList", "uima.cas.StringList", featOkTst);
    casFeatCode_synList  = (null == casFeat_synList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_synList).getCode();

 
    casFeat_source = jcas.getRequiredFeatureDE(casType, "source", "uima.cas.String", featOkTst);
    casFeatCode_source  = (null == casFeat_source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_source).getCode();

  }
}



    