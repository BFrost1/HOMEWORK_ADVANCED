package ua.homework.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import ua.homework.annotations.Blochable;
import ua.homework.annotations.Color;
import ua.homework.annotations.OneEyed;
import ua.homework.annotations.Skinny;
import ua.homework.entity.Cat;

public class FreshCatFarchFactory {

	public void produceMincedMeat(List<Cat> list) {
		for (Cat cat : list) {
			System.out.println("Start " + cat);
			Class<? extends Cat> clazz = cat.getClass();
			if (checkClass(clazz) && checkMethods(clazz, 3) && checkFileds(clazz, "red")) {
				System.out.println("Sent to mince " + cat);
			} else {
				System.out.println("Released the cat " + cat);
			}
		}
	}

	private boolean checkClass(Class<? extends Cat> clazz) {
		Annotation[] classAnnotation = clazz.getAnnotations();
		for (int i = 0; i < classAnnotation.length; i++) {
			if (classAnnotation[i].annotationType().equals(Blochable.class) || classAnnotation[i].annotationType().equals(OneEyed.class)
					|| classAnnotation[i].annotationType().equals(Skinny.class)) {
				System.out.println("Cat Blochable/OneEyed/Skinny");
				return false;
			}
		}
		System.out.println("Cat is not Blochable/OneEyed/Skinny");
		return true;
	}

	private boolean checkMethods(Class<? extends Cat> clazz, int limitation) {
		int countMethos = 0;
		Method[] method = clazz.getMethods();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getDeclaringClass().equals(clazz)) {
				countMethos++;
			}
		}
		System.out.println("Number of methods " + countMethos);
		return countMethos > limitation ? false : true;
	}

	private boolean checkFileds(Class<? extends Cat> clazz, String color) {
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getAnnotation(Color.class) != null
					&& fields[i].getAnnotation(Color.class).color().equals("color")) {
				System.out.println("Cat red");
				return false;
			}
		}
		return true;
	}
}
