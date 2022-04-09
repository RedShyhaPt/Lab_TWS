
package client.client_generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.client_generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllClients_QNAME = new QName("http://server/", "getAllClients");
    private final static QName _GetClientsByContact_QNAME = new QName("http://server/", "getClientsByContact");
    private final static QName _GetClientsByCountryAndSex_QNAME = new QName("http://server/", "getClientsByCountryAndSex");
    private final static QName _GetClientsByNameResponse_QNAME = new QName("http://server/", "getClientsByNameResponse");
    private final static QName _GetClientsByCityResponse_QNAME = new QName("http://server/", "getClientsByCityResponse");
    private final static QName _GetAllClientsResponse_QNAME = new QName("http://server/", "getAllClientsResponse");
    private final static QName _GetClientsByCity_QNAME = new QName("http://server/", "getClientsByCity");
    private final static QName _GetClientsByName_QNAME = new QName("http://server/", "getClientsByName");
    private final static QName _GetClientsById_QNAME = new QName("http://server/", "getClientsById");
    private final static QName _GetClientsByIdResponse_QNAME = new QName("http://server/", "getClientsByIdResponse");
    private final static QName _GetClientsByNameAndCityResponse_QNAME = new QName("http://server/", "getClientsByNameAndCityResponse");
    private final static QName _GetClientsByContactResponse_QNAME = new QName("http://server/", "getClientsByContactResponse");
    private final static QName _GetClientsByCountryAndSexResponse_QNAME = new QName("http://server/", "getClientsByCountryAndSexResponse");
    private final static QName _GetClientsByNameAndCity_QNAME = new QName("http://server/", "getClientsByNameAndCity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.client_generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClientsByContact }
     * 
     */
    public GetClientsByContact createGetClientsByContact() {
        return new GetClientsByContact();
    }

    /**
     * Create an instance of {@link GetAllClients }
     * 
     */
    public GetAllClients createGetAllClients() {
        return new GetAllClients();
    }

    /**
     * Create an instance of {@link GetClientsByNameAndCity }
     * 
     */
    public GetClientsByNameAndCity createGetClientsByNameAndCity() {
        return new GetClientsByNameAndCity();
    }

    /**
     * Create an instance of {@link GetClientsByCountryAndSexResponse }
     * 
     */
    public GetClientsByCountryAndSexResponse createGetClientsByCountryAndSexResponse() {
        return new GetClientsByCountryAndSexResponse();
    }

    /**
     * Create an instance of {@link GetClientsByNameAndCityResponse }
     * 
     */
    public GetClientsByNameAndCityResponse createGetClientsByNameAndCityResponse() {
        return new GetClientsByNameAndCityResponse();
    }

    /**
     * Create an instance of {@link GetClientsByContactResponse }
     * 
     */
    public GetClientsByContactResponse createGetClientsByContactResponse() {
        return new GetClientsByContactResponse();
    }

    /**
     * Create an instance of {@link GetClientsByIdResponse }
     * 
     */
    public GetClientsByIdResponse createGetClientsByIdResponse() {
        return new GetClientsByIdResponse();
    }

    /**
     * Create an instance of {@link GetClientsByName }
     * 
     */
    public GetClientsByName createGetClientsByName() {
        return new GetClientsByName();
    }

    /**
     * Create an instance of {@link GetClientsById }
     * 
     */
    public GetClientsById createGetClientsById() {
        return new GetClientsById();
    }

    /**
     * Create an instance of {@link GetClientsByCityResponse }
     * 
     */
    public GetClientsByCityResponse createGetClientsByCityResponse() {
        return new GetClientsByCityResponse();
    }

    /**
     * Create an instance of {@link GetAllClientsResponse }
     * 
     */
    public GetAllClientsResponse createGetAllClientsResponse() {
        return new GetAllClientsResponse();
    }

    /**
     * Create an instance of {@link GetClientsByCity }
     * 
     */
    public GetClientsByCity createGetClientsByCity() {
        return new GetClientsByCity();
    }

    /**
     * Create an instance of {@link GetClientsByCountryAndSex }
     * 
     */
    public GetClientsByCountryAndSex createGetClientsByCountryAndSex() {
        return new GetClientsByCountryAndSex();
    }

    /**
     * Create an instance of {@link GetClientsByNameResponse }
     * 
     */
    public GetClientsByNameResponse createGetClientsByNameResponse() {
        return new GetClientsByNameResponse();
    }

    /**
     * Create an instance of {@link Clients }
     * 
     */
    public Clients createClients() {
        return new Clients();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAllClients")
    public JAXBElement<GetAllClients> createGetAllClients(GetAllClients value) {
        return new JAXBElement<GetAllClients>(_GetAllClients_QNAME, GetAllClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByContact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByContact")
    public JAXBElement<GetClientsByContact> createGetClientsByContact(GetClientsByContact value) {
        return new JAXBElement<GetClientsByContact>(_GetClientsByContact_QNAME, GetClientsByContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByCountryAndSex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByCountryAndSex")
    public JAXBElement<GetClientsByCountryAndSex> createGetClientsByCountryAndSex(GetClientsByCountryAndSex value) {
        return new JAXBElement<GetClientsByCountryAndSex>(_GetClientsByCountryAndSex_QNAME, GetClientsByCountryAndSex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByNameResponse")
    public JAXBElement<GetClientsByNameResponse> createGetClientsByNameResponse(GetClientsByNameResponse value) {
        return new JAXBElement<GetClientsByNameResponse>(_GetClientsByNameResponse_QNAME, GetClientsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByCityResponse")
    public JAXBElement<GetClientsByCityResponse> createGetClientsByCityResponse(GetClientsByCityResponse value) {
        return new JAXBElement<GetClientsByCityResponse>(_GetClientsByCityResponse_QNAME, GetClientsByCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAllClientsResponse")
    public JAXBElement<GetAllClientsResponse> createGetAllClientsResponse(GetAllClientsResponse value) {
        return new JAXBElement<GetAllClientsResponse>(_GetAllClientsResponse_QNAME, GetAllClientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByCity")
    public JAXBElement<GetClientsByCity> createGetClientsByCity(GetClientsByCity value) {
        return new JAXBElement<GetClientsByCity>(_GetClientsByCity_QNAME, GetClientsByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByName")
    public JAXBElement<GetClientsByName> createGetClientsByName(GetClientsByName value) {
        return new JAXBElement<GetClientsByName>(_GetClientsByName_QNAME, GetClientsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsById")
    public JAXBElement<GetClientsById> createGetClientsById(GetClientsById value) {
        return new JAXBElement<GetClientsById>(_GetClientsById_QNAME, GetClientsById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByIdResponse")
    public JAXBElement<GetClientsByIdResponse> createGetClientsByIdResponse(GetClientsByIdResponse value) {
        return new JAXBElement<GetClientsByIdResponse>(_GetClientsByIdResponse_QNAME, GetClientsByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByNameAndCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByNameAndCityResponse")
    public JAXBElement<GetClientsByNameAndCityResponse> createGetClientsByNameAndCityResponse(GetClientsByNameAndCityResponse value) {
        return new JAXBElement<GetClientsByNameAndCityResponse>(_GetClientsByNameAndCityResponse_QNAME, GetClientsByNameAndCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByContactResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByContactResponse")
    public JAXBElement<GetClientsByContactResponse> createGetClientsByContactResponse(GetClientsByContactResponse value) {
        return new JAXBElement<GetClientsByContactResponse>(_GetClientsByContactResponse_QNAME, GetClientsByContactResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByCountryAndSexResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByCountryAndSexResponse")
    public JAXBElement<GetClientsByCountryAndSexResponse> createGetClientsByCountryAndSexResponse(GetClientsByCountryAndSexResponse value) {
        return new JAXBElement<GetClientsByCountryAndSexResponse>(_GetClientsByCountryAndSexResponse_QNAME, GetClientsByCountryAndSexResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsByNameAndCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getClientsByNameAndCity")
    public JAXBElement<GetClientsByNameAndCity> createGetClientsByNameAndCity(GetClientsByNameAndCity value) {
        return new JAXBElement<GetClientsByNameAndCity>(_GetClientsByNameAndCity_QNAME, GetClientsByNameAndCity.class, null, value);
    }

}
