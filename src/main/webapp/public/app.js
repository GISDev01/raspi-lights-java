var Lightswitch = React.createClass({

    getInitialState: function () {
        return {display: true};
    },
    handleDelete() {
        var self = this;
        $.ajax({
            url: self.props.lightswitch._links.self.href,
            type: 'DELETE',
            success: function (result) {
                self.setState({display: false});
            },
            error: function (xhr, ajaxOptions, thrownError) {
                toastr.error(xhr.responseJSON.message);
            }
        });
    },
    render: function () {

        if (this.state.display == false) return null;
        else
            return (
                <tr>
                    <td>{this.props.lightswitch.name}</td>
                    <td>{this.props.lightswitch.state}</td>
                    <td>
                        <button className="btn btn-info" onClick={this.handleDelete}>Remove Switch</button>
                    </td>
                </tr>
            );
    }
});

var LightswitchTable = React.createClass({

    render: function () {

        var rows = [];
        this.props.lightSwitches.forEach(function (lightswitch) {
            rows.push(
                <Lightswitch lightswitch={lightswitch} key={lightswitch.name}/>);
        });

        return (
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>State</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>
        );
    }
});

var App = React.createClass({

    loadLightswitchesFromServer: function () {
        console.log("Getting Switches from Server.");

        var self = this;
        $.ajax({
            url: "http://localhost:8080/treeapi/lightSwitches",
        }).then(function (data) {
            console.log(data);
            self.setState({lightSwitches: data._embedded.lightSwitches});
        });

    },

    getInitialState: function () {
        console.log("Getting Initial State");
        return {lightSwitches: []};
    },

    componentDidMount: function () {
        console.log("Componenet Did Mount");
        this.loadLightswitchesFromServer();
    },

    render() {
        return ( <LightswitchTable lightSwitches={this.state.lightSwitches}/> );
    }
});

ReactDOM.render(<App/>, document.getElementById('root'));
