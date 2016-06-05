package util;

import Answer.*;
import Paper.*;
import Question.*;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class IO {
	SAXBuilder builder = new SAXBuilder();

	/*
	 * read all page(tests and surveys) from pageInfo.xml :
	 * pageName,personName,type
	 */
	public List<String>[] readInfo() {
		InputStream file;
		Element root = null;
		try {
			file = new FileInputStream("src/xml/pageInfo.xml");
			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Element> pageList = root.getChildren("pageName");
		List<String>[] pageName = new List[2];
		pageName[0] = new LinkedList<String>();// survey
		pageName[1] = new LinkedList<String>();// test
		for (int i = 0; i < pageList.size(); i++) {
			if (pageList.get(i).getAttributeValue("type").equals("test")) {
				pageName[1].add(pageList.get(i).getText());
			} else {
				pageName[0].add(pageList.get(i).getText());
			}
		}
		return pageName;
	}

	/*
	 * read all pages(tests or surveys) created by 'personName' from
	 * pageInfo.xml : pageName,personName,type
	 */
	public List<String>[] readInfo(String personName) {
		InputStream file;
		Element root = null;
		try {
			file = new FileInputStream("src/xml/pageInfo.xml");
			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Element> pageList = root.getChildren("pageName");
		List<String>[] pageName = new List[2];
		pageName[0] = new LinkedList<String>();// survey
		pageName[1] = new LinkedList<String>();// test
		for (int i = 0; i < pageList.size(); i++) {
			if (pageList.get(i).getAttributeValue("type").equals("test")
					&& pageList.get(i).getAttributeValue("personName").equals(personName)) {
				pageName[1].add(pageList.get(i).getText());
			} else if (pageList.get(i).getAttributeValue("personName").equals(personName)) {
				pageName[0].add(pageList.get(i).getText());
			}
		}
		return pageName;
	}

	/*
	 * read all type-pageName-personName from pageInfo.xml :
	 * pageName,personName,type
	 */
	public List<List<String>> readpageName_type_personNameInfo() {
		InputStream file;
		Element root = null;
		try {
			file = new FileInputStream("src/xml/pageInfo.xml");
			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Element> pageList = root.getChildren("pageName");
		List<List<String>> pageName_type_personName = new LinkedList<List<String>>();

		for (int i = 0; i < pageList.size(); i++) {
			List<String> pair = new LinkedList<String>();
			pair.add(pageList.get(i).getText());
			pair.add(pageList.get(i).getAttributeValue("type"));
			pair.add(pageList.get(i).getAttributeValue("personName"));
			pageName_type_personName.add(pair);
		}
		return pageName_type_personName;
	}

	/* read a certain page from 'pageName'.xml : totalScore,testMinute,type,questions */
	public Page readPage(String pageName) {
		InputStream file;
		Element root = null;
		try {
			file = new FileInputStream("src/xml/" + pageName + ".xml");
			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page page;
		if (root.getAttribute("type").getValue().equals("test")) {
			Test test = new Test(pageName, root.getChildText("personName"),Integer.parseInt(root.getChildText("totalScore")),Integer.parseInt(root.getChildText("testMinute")));
			page = test;
		} else {
			Survey survey = new Survey(pageName, root.getChildText("personName"));
			page = survey;
		}
		
		Element questions = root.getChild("questions");
		List<Element> questionList = questions.getChildren();
		System.out.println("read page-->question num:"+questionList.size());
		if(questionList.size()==0){
			return page;
		}
		for (int i = 0; i < questionList.size(); i++) {
			Element question = questionList.get(i);
			int type = Integer.parseInt(question.getAttributeValue("type"));
			Question q = null;
			switch (type) {
			case 0:
				q = this.readDecideQuestion(question);
				break;
			case 1:
				q = this.readChoiceQuestion(question);
				break;
			case 2:
				q = this.readShortEssayAnswer(question);
				break;
			case 3:
				q = this.readEssayQuestion(question);
				break;
			case 4:
				q = this.readRankQuestion(question);
				break;
			case 5:
				q = this.readMapQuestion(question);
				break;
			}
			page.addQuestion(q);
		}
		return page;
	}

	public Question readDecideQuestion(Element question) {
		DecideQuestion decide ;
		String prompt = question.getChildText("prompt");
		
		if (question.getAttributeValue("pageType").equals("test")&&question.getAttributeValue("isScore").equals("1")) {
			DecideAnswer answer = new DecideAnswer(question.getChildText("answer"));
			int score = Integer.parseInt(question.getChildText("score"));
			decide = new DecideQuestion(prompt, answer, score);
		}else{
			 decide = new DecideQuestion(prompt);
		}
		return decide;
	}

	public Question readChoiceQuestion(Element question) {
		ChoiceQuestion choice;
		String prompt = question.getChildText("prompt");
		
		List<Element> items = question.getChild("items").getChildren();
		List<String> itemstr = new LinkedList<String>();
		for (int i = 0; i < items.size(); i++) {
			Element item = items.get(i);
			System.out.println("items:"+i+" :"+item.getText());
			itemstr.add(item.getText());
		}
	
		if (question.getAttributeValue("pageType").equals("test")&&question.getAttributeValue("isScore").equals("1")) {
			ChoiceAnswer answer = new ChoiceAnswer(question.getChildText("answer"));
			int score = Integer.parseInt(question.getChildText("score"));
			choice = new ChoiceQuestion(prompt, itemstr, answer, score);
		}else{
			choice = new ChoiceQuestion(question.getChildText("prompt"), itemstr);
		}
		return choice;
	}

	public Question readShortEssayAnswer(Element question) {
		ShortEssayQuestion text ;
		String prompt = question.getChildText("prompt");
		
		if (question.getAttributeValue("pageType").equals("test")&&question.getAttributeValue("isScore").equals("1")) {
			ShortEssayAnswer answer = new ShortEssayAnswer(question.getChildText("answer"));
			int score  = Integer.parseInt(question.getChildText("score"));
			text = new ShortEssayQuestion(prompt, answer, score);
		}
		else{
			text = new ShortEssayQuestion(prompt);
		}
		return text;
	}

	public Question readEssayQuestion(Element question) {
		EssayQuestion essay;
		String prompt = question.getChildText("prompt");
		
		if (question.getAttributeValue("pageType").equals("test")) {
			EssayAnswer answer = new EssayAnswer(question.getChildText("answer"));
			int score  = Integer.parseInt(question.getChildText("score"));
			essay = new EssayQuestion(prompt, answer, score);
		}else{
			essay = new EssayQuestion(prompt);
		}
		return essay;
	}

	public Question readRankQuestion(Element question) {
		RankQuestion rank ;
		String prompt = question.getChildText("prompt");
		
		List<Element> items = question.getChild("items").getChildren();
		List<String> itemstr = new LinkedList<String>();
		for (int i = 0; i < items.size(); i++) {
			Element item = items.get(i);
			itemstr.add(item.getText());
		}
		
		if (question.getAttributeValue("pageType").equals("test")&&question.getAttributeValue("isScore").equals("1")) {
			RankAnswer answer = new RankAnswer(question.getChildText("answer"));
			int score = Integer.parseInt(question.getChildText("score"));
			rank = new RankQuestion(prompt, itemstr, answer, score);
		}else{
			rank = new RankQuestion(prompt, itemstr);
		}
		return rank;
	}

	public Question readMapQuestion(Element question) {
		MapQuestion map ;
		String prompt = question.getChildText("prompt");
		
		Element side1 = question.getChild("side1");
		List<Element> sideList1 = side1.getChildren();
		List<String> side1Str = new LinkedList<String>();
		for (int j = 0; j < sideList1.size(); j++) {
			side1Str.add(sideList1.get(j).getText());
		}
		Element side2 = question.getChild("side2");
		List<Element> sideList2 = side2.getChildren();
		List<String> side2Str = new LinkedList<String>();
		for (int j = 0; j < sideList2.size(); j++) {
			side2Str.add(sideList2.get(j).getText());
		}
		
		if (question.getAttributeValue("pageType").equals("test")&&question.getAttributeValue("isScore").equals("1")) {
			MapAnswer answer = new MapAnswer(transMapAnswer(question.getChildText("answer")));
			int score = Integer.parseInt(question.getChildText("score"));
			 map = new MapQuestion(prompt, side1Str, side2Str, answer, score);
		}else{
			 map = new MapQuestion(prompt, side1Str, side2Str);
		}
		
		return map;
	}

	/* save elements in pageInfo.xml : pageName,personName,type */
	public void writeInfo(List<List<String>> pageName_type_personName) {
		Element root = new Element("totalInfo");

		for (int i = 0; i < pageName_type_personName.size(); i++) {
			Element pageEle = new Element("pageName");
			pageEle.addContent(pageName_type_personName.get(i).get(0));
			pageEle.setAttribute("type", pageName_type_personName.get(i).get(1));
			pageEle.setAttribute("personName", pageName_type_personName.get(i).get(2));
			root.addContent(pageEle);
		}

		Document doc = new Document(root);
		try {
			FileOutputStream out = new FileOutputStream("src/xml/pageInfo.xml");
			XMLOutputter outputter = new XMLOutputter();
			Format f = Format.getPrettyFormat();
			outputter.setFormat(f);
			outputter.output(doc, out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writePage(Page page) {
		Element root = new Element("Page");
		root.addContent(new Element("personName").setText(page.getPersonName()));
		if (page.getType() == Page.TEST) {
			root.setAttribute("type", "test");
			root.addContent(new Element("totalScore").setText(((Test) page).getTotalScore() + ""));
			root.addContent(new Element("testMinute").setText(((Test) page).getTestMinute() + ""));
		}else{
			root.setAttribute("type", "survey");
		}

		List<Question> questionList = page.getQuestionList();
		System.out.println("write page-->question num:"+questionList.size());
		Element questions = new Element("questions");
		for (int i = 0; i < questionList.size(); i++) {
			Question question = questionList.get(i);
			Element qe = null;
			switch (question.getType()) {
			case 0:{
				qe = this.savePromptQuestion(question,page.getType());
				System.out.println("save decide question");
				break;
			}
			case 1:{
				qe = this.saveItemQuestion(question,page.getType());
				System.out.println("save choice question");
				break;
			}
			case 2:{
				qe = this.savePromptQuestion(question,page.getType());
				System.out.println("save short essay question");
				break;
			}
			case 3:{
				qe = this.saveEssayQuestion(question,page.getType());
				System.out.println("save essay question");
				break;
			}
			case 4:{
				qe = this.saveItemQuestion(question,page.getType());
				System.out.println("save rank question");
				break;
			}
			case 5:{
				qe = this.savaMapQuestion(question,page.getType());
				System.out.println("save map question");
				break;
			}
			}
			questions.addContent(qe);
		}
		root.addContent(questions);
		Document doc = new Document(root);
		try {
			FileOutputStream out = new FileOutputStream("src/xml/" + page.getPageName() + ".xml");
			XMLOutputter outputter = new XMLOutputter();
			Format f = Format.getPrettyFormat();
			outputter.setFormat(f);
			outputter.output(doc, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Element savePromptQuestion(Question question,int pageType) {
		PromptQuestion promptQuestion = (PromptQuestion) question;
		Element ret = new Element("question");
		ret.setAttribute("type", question.getType() + "");
		ret.setAttribute("isScore", "1");
		if (pageType == Page.TEST)
			ret.setAttribute("pageType", "test");
		else
			ret.setAttribute("pageType", "survey");
		
		Element prompt = new Element("prompt");
		prompt.setText(question.getPrompt());
		ret.addContent(prompt);
		
		if (pageType == Page.TEST) {
			Element answerElement = new Element("answer");
			Answer an = promptQuestion.getAnswer();
			answerElement.setText(an.writeAnswer());
			ret.addContent(answerElement);
			ret.addContent(new Element("score").setText(question.getScore() + ""));
		}

		return ret;
	}

	public Element saveItemQuestion(Question question,int pageType) {
		ItemQuestion item = (ItemQuestion) question;
		Element ret = new Element("question");
		ret.setAttribute("type", question.getType() + "");
		ret.setAttribute("isScore", "1");
		if (pageType == Page.TEST)
			ret.setAttribute("pageType", "test");
		else
			ret.setAttribute("pageType", "survey");
		
		Element prompt = new Element("prompt");
		prompt.setText(question.getPrompt());
		ret.addContent(prompt);
		
		List<String> items = item.getItem();
		Element itemElement = new Element("items");
		for (int j = 0; j < items.size(); j++) {
			itemElement.addContent(new Element("item").setText(items.get(j)));
		}
		
		ret.addContent(itemElement);
		if (pageType == Page.TEST) {
			Element answerElement = new Element("answer");
			Answer an = item.getAnswer();
			answerElement.setText(an.writeAnswer());
			ret.addContent(answerElement);
			ret.addContent(new Element("score").setText(question.getScore() + ""));
		}
		
		return ret;
	}

	public Element savaMapQuestion(Question question,int pageType) {
		MapQuestion map = (MapQuestion) question;
		Element ret = new Element("question");
		ret.setAttribute("type", question.getType() + "");
		ret.setAttribute("isScore", "1");
		if (pageType == Page.TEST)
			ret.setAttribute("pageType", "test");
		else
			ret.setAttribute("pageType", "survey");
		
		Element prompt = new Element("prompt");
		prompt.setText(question.getPrompt());
		ret.addContent(prompt);

		List<String> side1 = map.getLeftItem();
		Element item1 = new Element("side1");
		for (int j = 0; j < side1.size(); j++) {
			item1.addContent(new Element("left").setText(side1.get(j)));
		}
		ret.addContent(item1);

		List<String> side2 = map.getRightItem();
		Element item2 = new Element("side2");
		for (int j = 0; j < side2.size(); j++) {
			item2.addContent(new Element("right").setText(side2.get(j)));
		}
		ret.addContent(item2);
		
		if (pageType == Page.TEST) {
			Element answerElement = new Element("answer");
			MapAnswer an = (MapAnswer)map.getAnswer();
			answerElement.setText(an.writeAnswer());
			ret.addContent(answerElement);
		    ret.addContent(new Element("score").setText(question.getScore() + ""));
		}

		return ret;
	}

	public Element saveEssayQuestion(Question question,int pageType) {
		Element ret = new Element("question");
		ret.setAttribute("type", question.getType() + "");
		ret.setAttribute("isScore", "0");
		if (pageType == Page.TEST)
			ret.setAttribute("pageType", "test");
		else
			ret.setAttribute("pageType", "survey");
		
		Element prompt = new Element("prompt");
		prompt.setText(question.getPrompt());
		if (pageType == Page.TEST) {
			ret.addContent(new Element("score").setText(question.getScore() + ""));
		}
		ret.addContent(prompt);
		return ret;
	}

	public int[][] transMapAnswer(String answer){
		String[] answers = answer.split(" ");
		int[][] answerPair = new int[answers.length][2];
		for(int i=0;i<answers.length;i++){
			answerPair[i][0]=i;
			answerPair[i][1]=Integer.parseInt(answers[i]);
		}
		return answerPair;
	}

	/* get all recordNames of a page */
	public List<String> readRecordInfo(String pageName) {
		InputStream file;
		Element root = null;
		try {
			File recordFile = new File("src/xml/record/" + pageName + "-recordInfo.xml");
			if (!recordFile.exists()) {
				return new LinkedList<String>();
			}
			file = new FileInputStream("src/xml/record/" + pageName + "-recordInfo.xml");

			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Element> pageList = root.getChildren("record");
		List<String> records = new LinkedList<String>();
		for (int i = 0; i < pageList.size(); i++) {
			records.add(pageList.get(i).getText());
		}
		return records;
	}

	/* read a certain record */
	public Record readRecord(String recordName) {

		InputStream file;
		Element root = null;
		try {
			file = new FileInputStream("src/xml/record/" + recordName + ".xml");
			Document document = builder.build(file);// 获得文档对象
			root = document.getRootElement();// 获得根节点

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] pageName_personName = recordName.split("-");
		Record record = new Record(pageName_personName[0],pageName_personName[1]);
		
		record.addScore(Integer.parseInt(root.getChildText("score")));
		Element answers = root.getChild("answers");
		List<Element> answerList = answers.getChildren();
		System.out.println(answerList.size());
		for (int i = 0; i < answerList.size(); i++) {
			Element answer = answerList.get(i);
			int type = Integer.parseInt(answer.getAttributeValue("type"));
			switch (type) {
			case 0:
				DecideAnswer decide = new DecideAnswer(answer.getText());
				record.addAnwser(decide);
				break;
			case 1:
				ChoiceAnswer choice = new ChoiceAnswer(answer.getText());
				record.addAnwser(choice);
				break;
			case 2:
				ShortEssayAnswer text = new ShortEssayAnswer(answer.getText());
				record.addAnwser(text);
				break;
			case 4:
				RankAnswer rank = new RankAnswer(answer.getText());
				record.addAnwser(rank);
				break;
			case 5:{
				MapAnswer map = new MapAnswer(transMapAnswer(answer.getText()));
				record.addAnwser(map);
				break;
			}
			}
		}
		return record;
	}

	public void writeRecordInfo(String pageName, List<String> recordName) {
		Element root = new Element("Records");
		for (int i = 0; i < recordName.size(); i++) {
			Element record = new Element("record");
			record.setText(recordName.get(i));
			root.addContent(record);
		}

		Document doc = new Document(root);
		try {
			FileOutputStream out = new FileOutputStream("src/xml/record/" + pageName + "-recordInfo.xml");
			XMLOutputter outputter = new XMLOutputter();
			Format f = Format.getPrettyFormat();
			outputter.setFormat(f);
			outputter.output(doc, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeRecord(String recordName, Record record) {
		Element root = new Element("Record");
		//Element personName = new Element("personName");
		//personName.setText(record.getPersonName());
		//root.addContent(personName);
		Element score = new Element("score");
		score.setText(record.getScore() + "");
		Element answers = new Element("answers");
		root.addContent(score);
		Iterator<Answer> iterator = record.iterator();

		while (iterator.hasNext()) {
			Answer answer = iterator.next();
			Element answerElement = new Element("answer");
			answerElement.setAttribute("type", answer.getType() + "");
			answerElement.setText(answer.writeAnswer());
			answers.addContent(answerElement);
		}

		root.addContent(answers);

		Document doc = new Document(root);
		try {
			FileOutputStream out = new FileOutputStream("src/xml/record/" + recordName + ".xml");
			XMLOutputter outputter = new XMLOutputter();
			Format f = Format.getPrettyFormat();
			outputter.setFormat(f);
			outputter.output(doc, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
