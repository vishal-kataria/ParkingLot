package dto;

public class GenerateTicketResponseDTO {

    private Long ticketId;
    private String operatorName;

    private int SpotNumber;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Long getTicketId() {

        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getSpotNumber() {
        return SpotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        SpotNumber = spotNumber;
    }
}
