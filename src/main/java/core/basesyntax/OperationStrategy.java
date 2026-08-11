package core.basesyntax;

public interface OperationStrategy {
    OperationHandler chooseOperationHandler(FruitTransaction.Operation operation);
}
