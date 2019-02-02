package chapter_four;

import java.util.ArrayList;
import java.util.HashMap;

public class Task7 {

    public static void main(String[] args) {
        Task7 t = new Task7();
        String[] projects = {"a","b","c","d","e","f"};
        String[][] dep = {{"d","a"}, {"b","f"}, {"d","b"}, {"a","f"}, {"c","d"}};
        Project[] pMas = t.findBuildProject(projects,dep);

        for(Project p : pMas){
            System.out.println(p.getName());
        }
    }

    public Project[] findBuildProject(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects,dependencies);
        return orderProjects(graph.getNodes());
    }

    public Project[] orderProjects(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];

        int offset = addNonDependend(order,projects,0);

        int toBeProcessed = 0;

        while(toBeProcessed < order.length){
            Project current = order[toBeProcessed];

            if(current == null) return null;

            for(Project p : current.getChildren()){
                p.derementDependecies();
            }

            offset = addNonDependend(order, current.getChildren(), offset);
            toBeProcessed++;
        }

        return order;
    }

    public int addNonDependend(Project[] order, ArrayList<Project> projects, int offset){
        for(Project p : projects){
            if(p.getDependencies() == 0) {
                order[offset] = p;
                offset++;
            }
        }
        return offset;
    }

    /**
     * projects - это названия проектов. Например a, b, c, d, e, f
     * dependencies - это свзяи между проектами. Наприме {{a,e}, {b,c}, {b,e}, {f,e}}
     * т.е получается что проектс e зависит от проекста a, проекст c зависит от проекта b и так далее.
     * */

    public Graph buildGraph(String[] projects, String[][] dependencies){
        Graph graph = new Graph();
        //создаем узлы
        for(String s : projects){
            graph.getOrCreateNode(s);
        }

        //создаем свзяи между узлами
        for(String[] edge : dependencies){
            graph.addEdge(edge[0],edge[1]);
        }
        return graph;
    }
}

class Graph{
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}

class Project{
    private ArrayList<Project> children = new ArrayList<>();
    private String name;
    private int dependencies;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node){
        children.add(node);
        node.incrementDependecies();
    }

    public void incrementDependecies(){dependencies++;}
    public void derementDependecies(){dependencies--;}
    public int getDependencies(){return dependencies;}

    public ArrayList<Project> getChildren() {
        return children;
    }

    public String getName(){
        return name;
    }
}