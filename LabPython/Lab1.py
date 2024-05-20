def two_sum_brute_force(nums, target):
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
    raise ValueError("No two sum solution")

def main():
    n = int(input("Enter the number of elements in the array: "))
    nums = []

    print("Enter the elements (integers only):")
    for _ in range(n):
        nums.append(int(input()))

    target = int(input("Enter the target sum: "))

    try:
        indices = two_sum_brute_force(nums, target)
        print(f"Indices of the two numbers are: {indices[0]} and {indices[1]}")
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()