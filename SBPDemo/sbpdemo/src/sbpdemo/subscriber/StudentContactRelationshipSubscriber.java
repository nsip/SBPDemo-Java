/*
* Copyright 2010-2011 Systemic Pty Ltd
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software distributed under the License 
* is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied.
* See the License for the specific language governing permissions and limitations under the License.
*/
package sbpdemo.subscriber;

import java.util.List;

import openadk.library.ADKException;
import openadk.library.SIFDataObject;
import openadk.library.Zone;
import openadk.library.student.StudentDTD;
import sbpdemo.utils.DemoHelper;
import systemic.sif.sbpframework.persist.model.SIFObjectKey;
import systemic.sif.sifcommon.mapping.MappingInfo;
import systemic.sif.sifcommon.model.SIFEvent;

public class StudentContactRelationshipSubscriber extends BaseSBPDemoSubscriber 
{
	public StudentContactRelationshipSubscriber(String subscriberID)
	{
		super(subscriberID, StudentDTD.STUDENTCONTACTRELATIONSHIP);
	}
	  
//	@Override
//	protected void addToInitialSyncQuery(Query query, Zone zone)
//	{
//		query.addCondition( StudentDTD.STUDENTCONTACTRELATIONSHIP_STUDENTCONTACTPERSONALREFID, ComparisonOperators.EQ, "7C834EA9EDA12090347F83297E1C290C" );
//		query.addCondition( StudentDTD.STUDENTCONTACTRELATIONSHIP_STUDENTPERSONALREFID, ComparisonOperators.EQ, "ABCD4EA9EDA12090347F83297EABCABC" );
//		query.addCondition( StudentDTD.STUDENTCONTACTRELATIONSHIP_CONTACTSEQUENCE, ComparisonOperators.EQ, "1" );
//	}	
	
	@Override
    public void processEvent(SIFEvent sifEvent, Zone zone, MappingInfo mappingInfo, String consumerID) throws ADKException
    {
		DemoHelper.dumpObject(sifEvent.getSifObject(), zone.getZoneId(), consumerID,DemoHelper.getDumpFileName(getAgentID(), getFrameworkProperties().getTestDir(getAgentID())));
    }

	@Override
    public void processResponse(SIFDataObject sifObject, Zone zone, MappingInfo mappingInfo, String consumerID) throws ADKException
    {
		DemoHelper.dumpObject(sifObject, zone.getZoneId(), consumerID, DemoHelper.getDumpFileName(getAgentID(), getFrameworkProperties().getTestDir(getAgentID())));
    }

	/* (non-Javadoc)
     * @see systemic.sif.sbpframework.subscriber.SBPBaseSubscriber#doesObjectExistInTargetSystem(java.lang.String, java.util.List, openadk.library.SIFDataObject)
     */
    @Override
    public boolean doesObjectExistInTargetSystem(String sifObjectName, List<SIFObjectKey> keyValues, SIFDataObject sifObject)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

}
