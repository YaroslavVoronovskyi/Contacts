package contacts.processors;

public interface IAddRecordProcessorFactory {

    IAddRecordProcessor getProcessorByRecordType(String recordType);
}
