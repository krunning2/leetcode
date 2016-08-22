from left to right, put res[i] = res[i - 1] * nums[i - 1]
from right to left, put res[i] = right * res[i]; right = right * nums[i]