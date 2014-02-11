package spring.mvc.util;

import org.springframework.core.convert.converter.Converter;

import com.kingyee.project.mapper.bean.User;
import com.thoughtworks.xstream.XStream;

public class XMLStrToUserConverter implements Converter<String, User> {

	@Override
	public User convert(String source) {
		source = "<user2 id2=\"23\"><name2><![CDATA[he2llo]]></name2><sex2>S</sex2></user2>";
		XStream xs = new XStream();
		xs.processAnnotations(User.class);
		User u = (User) xs.fromXML(source);
		return u;
	}
}
