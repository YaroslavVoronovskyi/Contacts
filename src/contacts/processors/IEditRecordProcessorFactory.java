package contacts.processors;

public interface IEditRecordProcessorFactory {

    IEditRecordProcessor getProcessorByFieldName(String fieldName);
}
