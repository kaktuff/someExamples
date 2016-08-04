package someExamples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by poskotinova-ls on 04.08.2016.
 */
public class FileSorterLengthStringDesc implements FileSorter{
    @Override
    public void sort(List<String> iListForSort){
        Collections.sort(iListForSort, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                }
        );
    }
}
