package com.ilopezluna.fullstack.entities;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;

public class Basic
{
	private ObjectId _id;

	private String name;

	public String getId()
	{
		return _id == null ? StringUtils.EMPTY : _id.toString();
	}

	public void setId(String id)
	{
		if (StringUtils.isNotEmpty( id ) )
			this._id = new ObjectId(id);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Basic basic = (Basic) o;

		if (_id != null ? !_id.equals(basic._id) : basic._id != null) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		return _id != null ? _id.hashCode() : 0;
	}
}
