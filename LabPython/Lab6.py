def can_finish(num_courses, prerequisites):
    adj = [[] for _ in range(num_courses)]
    for a, b in prerequisites:
        adj[b].append(a)

    visited = [0] * num_courses

    def dfs(course):
        if visited[course] == 1:
            return False
        if visited[course] == 2:
            return True

        visited[course] = 1
        for neighbor in adj[course]:
            if not dfs(neighbor):
                return False
        visited[course] = 2
        return True

    for i in range(num_courses):
        if visited[i] == 0:
            if not dfs(i):
                return False
    return True

def main():
    num_courses = int(input("Enter the number of courses: "))

    prerequisites = []
    print("Enter prerequisite pairs 'a b'. Enter 'done' when finished:")
    while True:
        input_line = input()
        if input_line.lower() == 'done':
            break
        a, b = map(int, input_line.split())
        prerequisites.append((a, b))

    result = can_finish(num_courses, prerequisites)
    print("Can finish all courses:", result)

if __name__ == "__main__":
    main()