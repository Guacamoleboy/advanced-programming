package designpatterns.refactoring;

/**
 * Strategy-pattern: fælles interface for søgealgoritmer i grafer.
 * BFS og DFS implementerer begge dette interface og kan skiftes dynamisk.
 */
public interface GraphSearchStrategy {
    Node search(String targetName, Node start);
}
