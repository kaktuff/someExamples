package someExamples;

/**
 * Created by poskotinova-ls on 04.08.2016.
 */
public class FileSorterFactory {
    public static FileSorter getFileSorter(SortType sortType) throws Exception{
        if (sortType == SortType.ALPHABETICALLY) {
            return new FileSorterAlphabetically();
        } else if (sortType == SortType.LENGTH_STRING_ASC) {
            return new FileSorterLengthStringAsc();
        } else if (sortType == SortType.LENGTH_STRING_DESC) {
            return new FileSorterLengthStringDesc();
        }else{
            //в случае некорректного значения выдадим ошибку
            // как вариант можно сортировать по умолчанию - по алфавиту, но если будет опечатка, пользователь даже об ошибке не узнает
            throw new Exception("Incorrect value of sortType");
        }
    }
}