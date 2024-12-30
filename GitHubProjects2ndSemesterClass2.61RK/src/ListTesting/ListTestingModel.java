package ListTesting;

import java.util.*;

public class ListTestingModel {
    protected enum LIST_TYPES {ArrayList, LinkedList, TreeSet, HashSet};
    protected enum WHERE_CHOICES {Start, Middle, End};

    /**
     * Run the defined test, returning the total elapsed time in seconds
     * @param amountOfData The amount of elements to add to the list
     * @param listType The type of list to use
     * @return the elapsed time in seconds, as a float
     */
    public float runTest(Integer amountOfData, LIST_TYPES listType, WHERE_CHOICES whereChoice) {
        // Create the data objects in an array
        SampleData[] data = createData(amountOfData);
        Collection<SampleData> collection = createCollection(listType);

        // Perform the test
        long startTime = System.currentTimeMillis();
        if (listType == LIST_TYPES.HashSet || listType == LIST_TYPES.TreeSet) {
            addDataToCollection(data, collection);
        } else {
            addDataToList(data, (List<SampleData>) collection, whereChoice);
        }
        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0f;
    }

    private SampleData[] createData(Integer amountOfData) {
        SampleData[] data = new SampleData[amountOfData];
        for (int i = 0; i < amountOfData; i++) {
            data[i] = new SampleData();
        }
        return data;
    }

    private Collection<SampleData> createCollection(LIST_TYPES listType) {
        switch (listType) {
            case ArrayList:
                return new ArrayList<>();
            case LinkedList:
                return new LinkedList<>();
            case TreeSet:
                return new TreeSet<>();
            case HashSet:
                return new HashSet<>();
            default:
                throw new IllegalArgumentException("Invalid list type");
        }
    }

    private void addDataToCollection(SampleData[] data, Collection<SampleData> collection) {
        for (SampleData element : data) {
            collection.add(element);
        }
    }

    private void addDataToList(SampleData[] data, List<SampleData> list, WHERE_CHOICES whereChoice) {
        for (SampleData element : data) {
            int index = 0; // Default to Start
            if (whereChoice == WHERE_CHOICES.Middle) {
                index = list.size() / 2;
            } else if (whereChoice == WHERE_CHOICES.End) {
                index = list.size();
            }
            list.add(index, element);
        }
    }

    public float searchTest(Integer amountOfData, LIST_TYPES listType) {
        // Fill the collection
        SampleData[] data = createData(amountOfData);
        Collection<SampleData> collection = createCollection(listType);
        addDataToCollection(data, collection);

        // Select a random object to search
        SampleData searchObject = data[(int) (Math.random() * amountOfData)];

        // Search for the object and measure the time
        long startTime = System.currentTimeMillis();
        boolean found = collection.contains(searchObject);
        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0f;
    }

    public boolean isWhereChoicesApplicable(LIST_TYPES listType) {
        return listType == LIST_TYPES.ArrayList || listType == LIST_TYPES.LinkedList;
    }
}