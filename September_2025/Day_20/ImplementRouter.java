//Question : https://leetcode.com/problems/implement-router/description/
class Packet {

    int source;
    int destination;
    int timestamp;
    
    Packet(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;                 // same object
        if (o == null || getClass() != o.getClass()) 
            return false; // type check
        Packet packet = (Packet) o;
        return source == packet.source &&
               destination == packet.destination &&
               timestamp == packet.timestamp;
    }
}

class Router {

    private static Map<Integer, List<Integer>> destinationToTimestampMap;
    private static Set<Packet> packetSet;
    private static Queue<Packet> packetQ;
    private int memoryLimit;
    
    public Router(int memoryLimit) {
        destinationToTimestampMap = new HashMap<>();
        packetSet = new HashSet<>();
        packetQ = new LinkedList<>();
        this.memoryLimit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if(packetSet.contains(packet))
            return false;
        packetQ.add(packet);
        packetSet.add(packet);
        destinationToTimestampMap.computeIfAbsent(destination, value -> new ArrayList<>()).add(timestamp);
        if(packetQ.size() > memoryLimit) {
            removePacket();
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if(packetQ.isEmpty())
            return new int[0];
        Packet packet = removePacket();
        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    private Packet removePacket() {
        Packet removePacket = packetQ.poll();
        packetSet.remove(removePacket);
        destinationToTimestampMap.get(removePacket.destination).remove(0);
        return removePacket;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!destinationToTimestampMap.containsKey(destination))
            return 0;

        List<Integer> list = destinationToTimestampMap.get(destination);

        return upperBound(list, endTime) - lowerBound(list, startTime);
    }

    private static int lowerBound(List<Integer> list, int x) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < x) 
                low = mid + 1;
            else 
                high = mid;
        }
        return low; // First index where arr[index] >= x
    }

    private static int upperBound(List<Integer> list, int x) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= x) low = mid + 1;
            else high = mid;
        }
        return low; // First index where arr[index] > x
    }
}
