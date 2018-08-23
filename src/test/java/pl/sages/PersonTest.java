package pl.sages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppAnnotations.class)
@ActiveProfiles("test")
public class PersonTest {

  @Autowired
  private Person person;

  @Test
  public void personTest(){
    System.out.println(person);
    //ExpressionParser parser = new SpelExpressionParser();
   // Expression exp = parser.parseExpression("name");
    Assert.notNull(person, "null person. DI not working");
  }
}
