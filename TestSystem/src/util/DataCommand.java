package util;

import java.util.LinkedList;
import java.util.List;

import Paper.Page;
import Paper.Record;
import Question.Question;
import TabulateResult.TabulateChoiceResult;
import TabulateResult.TabulateDecideResult;
import TabulateResult.TabulateEssayResult;
import TabulateResult.TabulateMapResult;
import TabulateResult.TabulateRankResult;
import TabulateResult.TabulateResult;
import TabulateResult.TabulateTextResult;

public class DataCommand {
	private IO io = new IO();

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}
	
	/*get all pageNames(tests or surveys)*/
	public List<String> getAllPageName(int type){
		List<String>[] pageName = io.readInfo();
		return pageName[type];
	}
	
	/*get all pageNames(tests or surveys) created by personName*/
	public List<String> getAllPageName(int type,String personName){
		List<String>[] pageName = io.readInfo(personName);
		return pageName[type];
	}
	
	/*get a certain page from by pageName*/
	public Page getPage(String pageName){
		return io.readPage(pageName);
	}
	
	/*update the registerFile of pageNameList:pageName-type-personName*/
	public void updatePageList(String pageName,int type,String personName){
		List<List<String>> pageName_type_personName = io.readpageName_type_personNameInfo();
		
		List<String> pair = new LinkedList<String>();
		pair.add(pageName);
		if(type==Page.TEST)
			pair.add("test");
		else
			pair.add("survey");
		pair.add(personName);
		pageName_type_personName.add(pair);
		
		io.writeInfo(pageName_type_personName);
	}
	
	/* save a page*/
	public void savePage(Page page){
		io.writePage(page);
	}
	
	/*get all record of a pageName*/
	public  List<Record> getAllRecords(String pageName){
		List<String> recordNames = io.readRecordInfo(pageName);
		List<Record> records = new LinkedList<Record>();
		for(int i=0;i<recordNames.size();i++){
			Record record = io.readRecord(recordNames.get(i));
			Page page = io.readPage(pageName);
			record.setPage(page);
			records.add(record);
		}
		return records;
	}
	
	/*get a record of a pageName of a person*/
	public  Record getRecord(String pageName,String personName){
		String recordName = pageName+"-"+personName;
		Record record = io.readRecord(recordName);
		Page page = io.readPage(pageName);
		record.setPage(page);
		return record;
	}
	
	/* create a record
	 * use this function when you try to answer a page*/
	public Page createRecord(String pageName,String personName) {
		Record record = new Record(pageName, personName);
		this.updateRecordList(record);
		return this.getPage(pageName);
	}
	
	
	/*update the registerFile of recordNameList for a certain pageName:pageName-type-personName*/
	public void updateRecordList(Record record){
		String pageName = record.getPageName();
		String recordName = pageName+"-"+record.getPersonName();
		List<String> recordNames = io.readRecordInfo(pageName);
		recordNames.add(recordName);
		io.writeRecordInfo(pageName, recordNames);
	}
	
	/*save a record*/
	public void saveRecord(Record record){
		String pageName = record.getPageName();
		String recordName = pageName+"-"+record.getPersonName();
		record.grade();
		io.writeRecord(recordName, record);
	}
	
	/* functions below will be used for tabulate
	 * you will get string result*/
	
	/* get a certain tabulate result string by questionIndex and pageName*/
	public String tabulate(String pageName,int questionIndex){
		List<Record> records = this.getAllRecords(pageName);
		String result = this.tabulate(records, questionIndex);
		return result;
	}
	
	private String tabulate(List<Record> records,int questionIndex){
		TabulateResult result = null;
		if(records.size()==0){
			return "";
		}
		
		List<Question> questionList = records.get(0).getPage().getQuestionList();
		Question q = questionList.get(questionIndex);
		int qtype = q.getType();
		
		switch (qtype) {
		case 1:
			result = new TabulateDecideResult(records,questionIndex);
			break;
		case 2:
			result = new TabulateChoiceResult(records,questionIndex);
			break;
		case 3:
			result = new TabulateTextResult(records,questionIndex);
            break;
        case 4:
        	result = new TabulateEssayResult(records,questionIndex);
            break;
		case 5:
			result = new TabulateRankResult(records,questionIndex);
			break;
		case 6:
			result = new TabulateMapResult(records,questionIndex);
			break;
		}
		return result.getResult();
	}
}
