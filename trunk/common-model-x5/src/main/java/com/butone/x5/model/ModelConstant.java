package com.butone.x5.model;

public abstract interface ModelConstant {
	public static final String PROCESS_BACKRULE_THEN_FLOWMODE_VALUES = "flowToFront,flowToFrontOrAgain,flowToAgain";
	public static final String BIZ_DIR_NAME = "BIZ";
	public static final String DATA_DIR_NAME = "data";
	public static final String MAPPING_FILE_SUFFIX = "mapping.m";
	public static final String MODEL_CFG_FILE = "model.config.xml";
	public static final String JNDI_PREFIX = "java:comp/env/";
	public static final String MODEL_FILE_EXTEND_NAME_M = ".m";
	public static final String ONTOLOGY_FILE_EXTEND_NAME = "ontology.m";
	public static final String MAPPING_FILE_EXTEND_NAME = "mapping.m";
	public static final String ACTION_FILE_EXTEND_NAME = "action.m";
	public static final String PROCEDURE_FILE_EXTEND_NAME = "procedure.m";
	public static final String PROCESS_FILE_EXTEND_NAME = "process.m";
	public static final String FN_FILE_EXTEND_NAME = "fn.m";
	public static final String CONFIG = "model.config.xml";
	public static final String MAPPING_TABLE_TYPE_VALUES = "owner-table,friend-table,relation-table";
	public static final String PROCESS_RULE_TASKASSIGNMODE_VALUSE = "together,singleness";
	public static final String PROCESS_EXECUTORRANGE_KIND_VALUES = "DPT,POS,PSM";
	public static final String PROCESS_BACKRULE_BACKRANGE_VALUES = "all,prev-activity,specified,start,prev-task";
	public static final String PROCESS_HASACTION_ACCESSPERMISSION_VALUES = "public,protected";
	public static final String KEY_TYPE_VALUES = "String,Integer,Boolean,Float,DateTime,Date,Time,Decimal";
	public static final String RELATION_DATATYPE_VALUES = "String,Integer,Boolean,Float,DateTime,Date,Time,Decimal,Blob,Text";
	public static final String ACTION_DATATYPE_VALUES = "String,Integer,Long,Double,Boolean,Float,DateTime,Date,Time,Decimal,List,Map,Object,Xml,Table";
	public static final String NOTICE_OCCASION_VALUES = "abortProcess,finishProcess,advanceProcess,backProcess";
	public static final String LISTENER_EVENT_VALUES = "before,after";
	public static final String WHOLE_PART_VALUES = "composition,aggregation";
	public static final String LANGUAGE_VALUES = "zh_CN,zh_TW,zh_HK,en_HK,en_US,en_GB,en_WW,en_CA,en_AU,en_IE,en_FI,fi_FI,en_DK,da_DK,en_IL,he_IL,en_ZA,en_IN,en_NO,en_SG,en_NZ,en_ID,en_PH,en_TH,en_MY,en_XA,ko_KR,ja_JP,nl_NL,nl_BE,pt_PT,pt_BR,fr_FR,fr_LU,fr_CH,fr_BE,fr_CA,es_LA,es_ES,es_AR,es_US,es_MX,es_CO,es_PR,de_DE,de_AT,de_CH,ru_RU,it_IT,el_GR,no_NO,hu_HU,tr_TR,cs_CZ,sl_SL,pl_PL,sv_SE,es_CL/i";
	public static final String JOIN_MODE_VALUES = "join,preempt";

	public final static String DictTableName = "M_SYSDICTITEM";
	public final static String EXT_System_core = "/ext/core/";
	public final static String EXT_System_data = "/ext/data/";
	public final static String EXT_System_func = "/ext/func/";

}
