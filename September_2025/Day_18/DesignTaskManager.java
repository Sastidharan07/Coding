//Question : https://leetcode.com/problems/design-task-manager/description/
class TaskManager {

    private TreeSet<Task> taskSet;

    private Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        this.taskSet = new TreeSet<>(new Comparator<Task>(){
            @Override
            public int compare(Task task1, Task task2) {
                if (task1.priority == task2.priority) {
                    return task2.taskId - task1.taskId;
                }
                return task2.priority - task1.priority;
            }
        });
        this.taskMap = new HashMap<>();
        for (List<Integer> row : tasks) {
            Task task = new Task(row.get(1), row.get(2), row.get(0));
            this.taskMap.put(task.taskId, task);
            this.taskSet.add(task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(taskId, priority, userId);
        this.taskMap.put(taskId, task);
        this.taskSet.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = this.taskMap.get(taskId);
        this.taskSet.remove(task);
        task.priority = newPriority;
        this.taskSet.add(task);
    }
    
    public void rmv(int taskId) {
        this.taskSet.remove(this.taskMap.get(taskId));
    }
    
    public int execTop() {
        if (taskSet.isEmpty()) {
            return -1;
        }
        Task task = this.taskSet.pollFirst();
        return task.userId;
    }
}
class Task {
    int taskId;
    int priority;
    int userId;
    public Task(int taskId, int priority, int userId) {
        this.taskId = taskId;
        this.priority = priority;
        this.userId = userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
