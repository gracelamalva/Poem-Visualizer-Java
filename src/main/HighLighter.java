package main;

import java.awt.Color;

import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class HighLighter {
		class Painter extends DefaultHighlighter.DefaultHighlightPainter {

			public Painter(Color color) {
				super(color);
				
			}
			
		}
		
		//set highlighter color and create painter object
				Painter painter = new Painter(Color.YELLOW);
				
		public void removeHighlights(JTextComponent textComp) {
			Highlighter hlight = textComp.getHighlighter();
			Highlighter.Highlight[] hlights = hlight.getHighlights();
			
			for (int i = 0; i < hlights.length; i++) {
				
				if (hlights[i].getPainter() instanceof Painter) {
					hlight.removeHighlight(hlights[i]);
				}
				
			}
		}
		
		public void highlight(JTextComponent textComp, String word) {
			
			//remove previous highlights
			//probably dont want this because we might need to run the highlight method multiple times
			//removeHighlights(textComp);
			
			try {
				Highlighter hLight = textComp.getHighlighter();
				Document doc = textComp.getDocument();
				String text = doc.getText(0, doc.getLength());
				int pos = 0;
				
				while ((pos = text.toUpperCase().indexOf(word.toUpperCase(), pos)) >= 0) {
					hLight.addHighlight(pos, pos + word.length(), painter);
					pos += word.length();
				}
				
			} catch (Exception e) {
				
			}
		}
		
	}

	
