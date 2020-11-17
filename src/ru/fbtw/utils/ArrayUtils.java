package ru.fbtw.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Версия 0.1
 *
 * Ссылка на github:
 *
 * */
public class ArrayUtils {

	private static final String DEFAULT_ARR_READ_MSG = "Введите массив ";
	private static final String DEFAULT_SPLIT = " ";
	private static String delimiter = " ";

	private static Random random = new Random();

	// TODO: 06.11.2020 Добавить функции для других типов
	public static int[] readIntArray(String messageSuffix){
		if(messageSuffix == null || messageSuffix.isEmpty()){
			messageSuffix = DEFAULT_ARR_READ_MSG;
		}else{
			messageSuffix = DEFAULT_ARR_READ_MSG + messageSuffix;
		}

		Scanner in = new Scanner(System.in);

		while (true){
			try {
				System.out.println(messageSuffix);
				System.out.println("Для разделения чисел используйте пробел");
				String arrayString = in.nextLine();

				return stringToIntArray(arrayString);
			}catch (NumberFormatException ex){
				System.out.println("Возникла ошибка попробуйте еще раз");
			}
		}

	}

	// TODO: 06.11.2020 Добавить функции для других типов
	private static int[] stringToIntArray(String data) throws NumberFormatException{
		return Arrays.stream(data.split(delimiter))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	public static <T> void printArray(T[] array, String delimiter){
		if(delimiter == null){
			delimiter = DEFAULT_SPLIT;
		}

		System.out.println();
		for (T t : array) {
			System.out.printf("%1$s%2$s", t, delimiter);
		}
	}

	// TODO: 06.11.2020 Добавить функции для других типов
	public static void printPrimitiveArray(int[] array, String delimiter){
		if(delimiter == null){
			delimiter = DEFAULT_SPLIT;
		}

		System.out.println();
		for (int num : array) {
			System.out.printf("%1$s%2$s", num, delimiter);
		}
	}


	public static int[] randomArray(int length){
		assert (length >0);


		int [] array = new int[length];
		for(int i = 0; i<array.length;i++){
			array[i] = random.nextInt();
		}

		return  array;
	}
	public static int[] randomArray(int length,int bound){

		int [] array = new int[length];
		for(int i = 0; i<array.length;i++){
			array[i] = random.nextInt(bound);
		}

		return  array;
	}

}
