package com.myyhhuang.transactional;

import com.myyhhuang.beanim.IMAPILog;
import com.myyhhuang.beanim.IMCounty;
import com.myyhhuang.constants.DATA_ENTRY_TYPE;

import java.util.List;

public interface IMServiceDao {	
	//0.Start
	public boolean modifyTableObj(DATA_ENTRY_TYPE data_entry_type, List<Object> tableObjList);
	public boolean modifyTable(DATA_ENTRY_TYPE data_entry_type, Object object);
	
	//1.IMCounty 發證地點行政區域
	public List<IMCounty> retriveIMCounty();
	
	//2.IMAPILog 記錄檔
	public IMAPILog retriveIMAPILog(int seqno);
}
