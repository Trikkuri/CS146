def is_anagram(s, t):
    if len(s) != len(t):
        return False

    char_counts = [0] * 26
    for i in range(len(s)):
        char_counts[ord(s[i]) - ord('a')] += 1
        char_counts[ord(t[i]) - ord('a')] -= 1

    for count in char_counts:
        if count != 0:
            return False

    return True

def main():
    s = input("Enter string (s): ")
    t = input("Enter string (t): ")

    result = is_anagram(s, t)
    print("Is anagram:", result)

if __name__ == "__main__":
    main()