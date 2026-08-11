package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> inputReport) {
        List<FruitTransaction> list = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] linesArray = inputReport.get(i).split(",");
            String operationCode = linesArray[0].trim();
            String fruit = linesArray[1].trim();
            int quantity = Integer.parseInt(linesArray[2].trim());
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getByCode(operationCode);
            list.add(new FruitTransaction(operation, fruit, quantity));

        }
        return list;
    }
}
