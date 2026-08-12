package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        int newBalance = currentQuantity - transaction.getQuantity();
        if (newBalance >= 0) {
            Storage.fruitStorage.put(fruit, newBalance);
        }
        throw new RuntimeException("It is impossible to buy more goods than are in stock");
    }
}
