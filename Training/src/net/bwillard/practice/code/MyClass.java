package net.bwillard.practice.code;

public class MyClass {
	public boolean canDeleteDocument(Document doc) {
        return (doc instanceof AuditProgramDocument);
    }
	
	public static void main(String[] args) {
		//System.out.println("2.1 " + selectedCFP.getDocument().getClassName());//DOES NOT COMPILE
		//Not sure what these tests are supposed to do for you....
		//System.out.println("2.2 " + selectedCFP.getDocument().getClass().getName());
		//System.out.println("2.3 " + selectedCFP.getDocument().getClass().getCanonicalName());
		//System.out.println("2.4 " + selectedCFP.getDocument().getClass().getSimpleName());
		
		MyClass mc = new MyClass();
		CaseFilePart cfp = new CaseFilePart();
		
		//TEST 1
		cfp.setDocument(new AuditProgramDocument());
		boolean canDelete = mc.canDeleteDocument(cfp.getDocument());
		System.out.println("Can we delete " + cfp.getDocument().getClass() + " " + canDelete);
		
		//TEST 2
		cfp.setDocument(new SomeOtherDocument());
		canDelete = mc.canDeleteDocument(cfp.getDocument());
		System.out.println("Can we delete " + cfp.getDocument().getClass() + " " + canDelete);
	}
	
}

class Document {}
class AuditProgramDocument extends Document {}
class SomeOtherDocument extends Document {}
class CaseFilePart {
    private Document document;
    public Document getDocument() {
        return document;
    }
    
    public void setDocument(Document document) {
    	this.document = document;
    }
}


