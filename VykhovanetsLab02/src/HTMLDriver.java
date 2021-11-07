
public class HTMLDriver
{

	public static void main(String[] args)
	{
		
		HTMLTree t = new HTMLTree();
		
		HTMLTag root = new HTMLTag("html", "");
		t.addRoot(root);
		
		HTMLTag head = new HTMLTag("head", "");
		t.add(root, head);
		
		HTMLTag title = new HTMLTag("title", "HTML title");
		t.add(head, title);
		
		HTMLTag body = new HTMLTag("body", "");
		t.add(root, body);
		
		HTMLTag heading1 = new HTMLTag("h1", "HTML Heading");
		t.add(body, heading1);
		
		HTMLTag ul = new HTMLTag("ul", "");
		t.add(body, ul);
		
		HTMLTag li1 = new HTMLTag("li", "List item one");
		t.add(ul, li1);
		
		HTMLTag li2 = new HTMLTag("li", "List item two");
		t.add(ul, li2);
		
		HTMLTag h2 = new HTMLTag("h2", "HTML Heading 2");
		t.add(body, h2);
		
		HTMLTag p = new HTMLTag("p", "A paragraph of text");
		t.add(body, p);


		t.printNodes();

	}

}
