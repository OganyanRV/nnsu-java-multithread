package Server;

import javax.jws.WebService;


public class Answer {
   String text;
   Boolean right;
   int[] points;

   public Answer(String text, Boolean right, int[] points) {
      this.text = text;
      this.right = right;
      this.points = new int[4];
      for (int i = 0; i < 4; ++i) {
         this.points[i] = points[i];
      }
   }

   public String getText() {
      return text;
   }

   public Boolean getRight() {
      return right;
   }

   public int[] getPoints() {
      return points;
   }
}
