/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016  Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License:
 * along with Grakn. If not, see <http://www.gnu.org/licenses/gpl.txt>.
 */

import ai.grakn.Grakn;
import ai.grakn.GraknGraph;
import ai.grakn.client.Client;

public class Main {
    private static final String SERVER_ADDRESS = "127.0.0.1:4567";
    private static final String keyspace = "FAMILY";
    private static String filePath = "family.owl";

    public static void main(String[] args) {
        if(!Client.serverIsRunning(SERVER_ADDRESS)){
            System.out.println("Please start Grakn Engine");
            System.out.println("You can get more information on how to do so using our setup guide: https://grakn.ai/pages/documentation/get-started/setup-guide.html");
            return;
        } else {
            System.out.println("=================================================================================================");
            System.out.println("|||||||||||||||||||||||||||||||||   Grakn OWL Migration Example   ||||||||||||||||||||||||||||||||");
            System.out.println("=================================================================================================");
        }
        // get connection to the graph
        GraknGraph graph = Grakn.factory(Grakn.DEFAULT_URI, keyspace).getGraph();

        OWLResourceMigrator.migrate(filePath, graph);
        OWLResourceMigrator.printInformationAboutWorld(graph);
    }
}
