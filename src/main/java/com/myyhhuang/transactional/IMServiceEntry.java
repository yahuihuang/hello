package com.myyhhuang.transactional;

import java.util.List;

import com.myyhhuang.beanim.IMAPILog;
import com.myyhhuang.beanim.IMCounty;
import com.myyhhuang.constants.DATA_ENTRY_TYPE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class IMServiceEntry {
	private static Logger logger = LogManager.getLogger(IMServiceEntry.class.getName());
	
	private static GenericXmlApplicationContext ctx = null;
	static {		
		ctx = new GenericXmlApplicationContext();
		ctx.load(new ClassPathResource("applicationContext.xml"));
		ctx.refresh();
	}
	private IMServiceDao imServiceDao = null;
	
	public IMServiceEntry() {
		imServiceDao = ctx.getBean("IMServiceDao", IMServiceDao.class);
		logger.info("imServiceDao init");
	}
	
	//0.Start
	public boolean modifyTableObj(DATA_ENTRY_TYPE data_entry_type, List<Object> tableObjList) {
		return imServiceDao.modifyTableObj(data_entry_type, tableObjList);
	}
	
	public boolean modifyTable(DATA_ENTRY_TYPE data_entry_type, Object object) {
		return imServiceDao.modifyTable(data_entry_type, object);
	}	
	
	//1.IMCounty 發證地點行政區域
	public List<IMCounty> retriveIMCounty() {
		return imServiceDao.retriveIMCounty();
	}
	
	//2.IMAPILog 記錄檔
	public IMAPILog retriveIMAPILog(int seqno) {
		return imServiceDao.retriveIMAPILog(seqno);		
	}
}
