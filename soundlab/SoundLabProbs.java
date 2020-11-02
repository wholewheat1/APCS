package soundlab;

public class SoundLabProbs {
	SoundLabProbs() {

	}

	public int lastIndexOf(int[] nums, int value) {
		if (indexOf(nums, value, 0) > -1) {
			return indexOf(nums, value, 0);

		} else {
			return -1;
		}

	}

	public int indexOf(int[] array, int key, int start) {
		int returnvalue = -1;
		for (int i = 0; i < array.length; ++i) {
			if (key == array[i]) {
				returnvalue = i;

			}
		}
		return returnvalue;
	}

	public int range(int[] nums) {
		return largestInt(nums) - smallestInt(nums);
	}

	public int smallestInt(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums[0];
	}

	public int largestInt(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums[nums.length - 1];
	}

	public int minDifference(int[] nums, int value) {
		int value2 = value + 1;
		int x = nums[value];
		int y = nums[value2];
		return x - y;
	}

	public String reverseWords(String str) {
		String[] words = str.split(" ");
		String reversedString = "";
		for (int i = words.length - 1; i >= 0; i--) {
			reversedString += words[i] + " ";

		}

		return reversedString;
	}

}
